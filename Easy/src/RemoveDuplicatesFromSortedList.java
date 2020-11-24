public class RemoveDuplicatesFromSortedList {
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
