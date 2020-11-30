import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 *     Given head, the head of a linked list, determine if the linked list has a cycle in it.
 *
 *     There is a cycle in a linked list if there is some node in the list that can be reached
 *     again by continuously following the next pointer.
 *     Internally, pos is used to denote the index of the node that tail's next pointer
 *     is connected to. Note that pos is not passed as a parameter.
 *
 *     Return true if there is a cycle in the linked list. Otherwise, return false.
 * </p>
 */
public class LinkedListCycle {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val=x;
            next=null;
        }
    }

    /**
     * We go through each node one by one and record each node's reference
     * (or memory address) in a hash table. If the current node is null, we have
     * reached the end of the list and it must not be cyclic.
     * If current node’s reference is in the hash table, then return true.
     * TC:O(n) SC:O(n)
     * @param head of linked list
     * @return true if it contains cycle else false
     */
    public boolean hasCycle(ListNode head){
        Set<ListNode> set=new HashSet<>();
        while (head!=null){
            if(set.contains(head)){
                return true;
            }
            else{
                set.add(head);
            }
            head=head.next;
        }
        return false;
    }

    /**
     * Two pointers
     * The space complexity can be reduced to O(1)O(1) by considering two pointers at different speed -
     * a slow pointer and a fast pointer. The slow pointer moves one step at a time
     * while the fast pointer moves two steps at a time.
     *
     * If there is no cycle in the list, the fast pointer will eventually reach
     * the end and we can return false in this case.
     *
     * Now consider a cyclic list and imagine the slow and fast pointers are two runners
     * racing around a circle track. The fast runner will eventually meet the slow runner.
     * @param head of linked list
     * @return true if it contains cycle else false
     */
    public boolean hasCycle2(ListNode head){
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(3);
        head.next=new ListNode(2);
        head.next.next=new ListNode(0);
        head.next.next.next=new ListNode(-4);
        head.next.next.next.next=head.next;
        System.out.println(new LinkedListCycle().hasCycle(head));
        System.out.println(new LinkedListCycle().hasCycle2(head));
    }
}
