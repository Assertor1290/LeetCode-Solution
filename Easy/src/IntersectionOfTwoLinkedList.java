import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 *     Write a program to find the node at which the intersection of two singly linked lists begins.
 * </p>
 */
public class IntersectionOfTwoLinkedList {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val=val;
            next=null;
        }
    }

    /**
     * Brute force
     * For each node ai in list A, traverse the entire list B and check if any node in list B coincides with ai.
     * Runtime: 802ms, Memory:41.7MB
     * TC: O(m*n) SC:O(1)
     * @param headA head of first linked list
     * @param headB head of second linked list
     * @return null if no intersection node else Intersecting node
     */
    public ListNode intersectNode(ListNode headA, ListNode headB){
        for (ListNode a = headA; a != null; a = a.next) {
            for (ListNode b = headB; b != null; b = b.next) {
                if (a == b) return a;
            }
        }
        return null;
    }

    /**
     * HashSet
     * Traverse List A and store every node in the HashSet.
     * Traverse List B and for every node, check if it exists in the HashSet.
     * Return the first such node. Else return null.
     * Runtime:7ms, Memory: 42.6MB
     * TC:O(m+n) SC:O(m) or O(n)
     * @param headA head of first linked list
     * @param headB head of second linked list
     * @return null if no intersection node else Intersecting node
     */
    public ListNode intersectNode2(ListNode headA, ListNode headB){
        Set<ListNode> set = new HashSet<>();
        ListNode node = headA;
        while (node != null) {
            set.add(node);
            node = node.next;
        }
        node = headB;
        while (node != null) {
            if(set.contains(node)) return node;
            node = node.next;
        }
        return null;
    }

    /**
     * Two Pointer
     * Runtime:1ms, Memory:41.5MB
     * TC:O(m+n) SC:O(1)
     *          1. Initialize two pointers ptr1 and ptr2  at the head1 and  head2.
     *          2. Traverse through the lists,one node at a time.
     *          3. When ptr1 reaches the end of a list, then redirect it to the head2.
     *          4. similarly when ptr2 reaches the end of a list, redirect it the head1.
     *          5. Once both of them go through reassigning,they will be equidistant from
     *             the collision point
     *          6. If at any node ptr1 meets ptr2, then it is the intersection node.
     *          7. After second iteration if there is no intersection node it returns NULL.
     * @param headA head of first linked list
     * @param headB head of second linked list
     * @return null if no intersection node else Intersecting node
     */
    public ListNode intersectNode3(ListNode headA, ListNode headB){
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        boolean flag1 = false;
        boolean flag2 = false;
        while (temp1 != null && temp2 != null) {
            if (temp1 == temp2) {
                return temp1;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
            if (temp1 == null && flag1 == false) {
                flag1 = true;
                temp1 = headB;
            }
            if (temp2 == null && flag2 == false) {
                flag2 = true;
                temp2 = headA;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        /**
         *      4 ----- 1 -----
         *                     \
         *                      \
         *                      8 ----- 4 ----5
         *                      /
         *                     /
         *  5 --- 6 --- 1 -----
         */
        ListNode list1=new ListNode(4);
        list1.next=new ListNode(1);
        list1.next.next=new ListNode(8);
        list1.next.next.next=new ListNode(4);
        list1.next.next.next.next=new ListNode(5);

        ListNode list2=new ListNode(5);
        list2.next=new ListNode(6);
        list2.next.next=new ListNode(1);
        list2.next.next.next=list1.next.next;

        ListNode intersect = new IntersectionOfTwoLinkedList().intersectNode(list1,list2);
        System.out.println(intersect.val);
        intersect = new IntersectionOfTwoLinkedList().intersectNode2(list1,list2);
        System.out.println(intersect.val);
        intersect = new IntersectionOfTwoLinkedList().intersectNode3(list1,list2);
        System.out.println(intersect.val);
    }
}
