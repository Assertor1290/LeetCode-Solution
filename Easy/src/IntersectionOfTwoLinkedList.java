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
    }
}
