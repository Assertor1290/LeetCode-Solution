/**
 * <p>
 *      Reverse a singly linked list.
 *      Example:
 *
 *      Input: 1->2->3->4->5->NULL
 *      Output: 5->4->3->2->1->NULL
 * </p>
 */
public class ReverseLinkedList {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val=val;
            next=null;
        }
    }

    /**
     * Iterative Approach
     * While you are traversing the list, change the current node's next pointer
     * to point to its previous element. Since a node does not have reference to its previous node,
     * you must store its previous element beforehand. You also need another pointer
     * to store the next node before changing the reference.
     * Do not forget to return the new head reference at the end
     * TC:O(n) SC:O(1)
     * @param head of linked list
     * @return head of reversed Linked List
     */
    public ListNode reverseList(ListNode head){
        ListNode next,previous=null;
        ListNode current=head;
        while (current!=null){
            //store next of current element before changing it
            next=current.next;
            //change next of current element to previous element
            current.next=previous;
            //change previous to current element
            previous=current;
            //change current element to next element
            current=next;
        }
        head=previous;
        return head;
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

        head.next=second;
        second.next=third;
        third.next=fourth;
        fourth.next=fifth;
        head=new ReverseLinkedList().reverseList(head);
        new ReverseLinkedList().printList(head);
    }
}
