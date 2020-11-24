/**
 * <p>
 *     Given a sorted linked list, delete all duplicates such that each element appear only once.
 * </p>
 */
public class RemoveDuplicatesFromSortedList {
    /**
     * TC: O(n)
     * SC: O(1)
     * @param head of linked list
     * @return head of linked list after deleting duplicates
     */
    public ListNode deleteDuplicates(ListNode head){
        ListNode cur=head;
        while (cur!=null && cur.next!=null){
            if(cur.val==cur.next.val){
                cur.next=cur.next.next;
            }
            else {
                cur=cur.next;
            }
        }
        return head;
    }
    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        ListNode l2=new ListNode(1);
        ListNode l3=new ListNode(2);
        head.next=l2;
        l2.next=l3;
        ListNode newHead= new RemoveDuplicatesFromSortedList().deleteDuplicates(head);
        while (newHead!=null){
            System.out.print(newHead.val+" ");
            newHead=newHead.next;
        }
    }
}
