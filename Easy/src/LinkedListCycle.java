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
    public static void main(String[] args) {
        ListNode head=new ListNode(3);
        head.next=new ListNode(2);
        head.next.next=new ListNode(0);
        head.next.next.next=new ListNode(-4);
        head.next.next.next.next=head.next;
        System.out.println(new LinkedListCycle().hasCycle(head));
    }
}
