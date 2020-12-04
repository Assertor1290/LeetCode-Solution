/**
 * <p>
 *      Remove all elements from a linked list of integers that have value val.
 * </p>
 */
public class RemoveLinkedList {
    static class ListNode {
      int val;
      ListNode next;
      ListNode(int val) {
          this.val = val;
      }
    }

    /**
     * Runtime:0ms, Memory:39.8MB
     * @param head of linked list
     * @param val to be removed
     * @return head of Linked List
     */
    public ListNode removeElements(ListNode head, int val) {
        // Set pointers.
        ListNode current, prev;

        // If the undesired elements are at the beginning of the list
        while(head != null && head.val == val)
        {
            head = head.next;
        }

        // Assign the pointers to the head.
        prev = head;
        current = head;

        // While we have not reached the end of the list.
        while(current != null)
        {
            // If we have found the value that is needed to be removed..
            if (current.val == val)
            {
                // Move the the 'prev' pointer so that the next element of 'prev' will be
                // the next element of 'current' instead current itself
                prev.next = current.next;
            }
            else
            {
                // Else 'prev' pointer will point at the same element as 'current'.
                prev = current;
            }
            // Move the 'current' pointer to the next element (next iteration).
            current = current.next;
        }
        return head; // Return the new list.
    }

    public void printList(ListNode head){
        while(head!=null){
            System.out.print(head.val+" ");
            head=head.next;
        }
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        ListNode second=new ListNode(2);
        ListNode third=new ListNode(3);
        ListNode fourth=new ListNode(4);
        ListNode fifth=new ListNode(5);
        ListNode fifthtwo=new ListNode(5);

        head.next=second;
        second.next=third;
        third.next=fourth;
        fourth.next=fifth;
        fifth.next=fifthtwo;
        head=new RemoveLinkedList().removeElements(head,5);
        new RemoveLinkedList().printList(head);
    }
}
