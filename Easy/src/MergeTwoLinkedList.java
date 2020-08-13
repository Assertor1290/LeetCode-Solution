/**
 *<p>Merge two sorted linked lists and return it as a new sorted list.
 *The new list should be made by splicing together the nodes of the first two lists.</p>
 */
public class MergeTwoLinkedList {
    /**
     * Iterative method to merge two sorted Linked List.
     * Runtime:0ms Memory:39MB
     * @param l1 first Linked List
     * @param l2 second Linked List
     * @return sorted List
     */
    public ListNode mergeTwoLists(ListNode l1,ListNode l2){

        /**
         * head = last
         * -----
         * | 0 |
         * -----
         */
        ListNode head=new ListNode(0);
        ListNode last=head;
        /**
         * Loop until we reach the end of any one of the list
         */
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                /**
                 * last
                 * ---------------
                 * | 0 | --> | 1 |
                 * ---------------
                 *           List 1 is now on 3
                 * -----------------------------------
                 * | 1 | --> | 3 | --> | 5 | --> | 7 |
                 * -----------------------------------
                 */
                last.next=l1;
                l1=l1.next;
            }
            else {
                last.next=l2;
                l2=l2.next;
            }
            last=last.next;
            /**
             *            last is now here on 1.
             * ---------------
             * | 0 | --> | 1 |
             * ---------------
             * Similarly we process further for the entire loop
             */
        }
        /**
         * Put the remaining elements of non empty list into last
         */
        if(l1==null){
            last.next=l2;
        }
        if(l2==null){
            last.next=l1;
        }
        return head.next;
    }

    /**
     * Recursive method to merge two linked list
     * @param l1 first Linked List
     * @param l2 second Linked List
     * @return sorted List
     */
    public ListNode mergeTwoLists2(ListNode l1,ListNode l2){
        if(l1==null) return l2;
        if()
    }
    public static void main(String[] args) {
        /**
         * Consider example:
         * List 1
         * -----------------------------------
         * | 1 | --> | 3 | --> | 5 | --> | 7 |
         * -----------------------------------
         * List 2
         * -------------------------
         * | 2 | --> | 4 | --> | 6 |
         * -------------------------
         */
        ListNode t1=new ListNode(1);
        ListNode t2=new ListNode(3);
        ListNode t3=new ListNode(5);
        ListNode t4=new ListNode(7);

        t1.next=t2;
        t2.next=t3;
        t3.next=t4;

        ListNode s1=new ListNode(2);
        ListNode s2=new ListNode(4);
        ListNode s3=new ListNode(6);

        s1.next=s2;
        s2.next=s3;

        ListNode newHead = new MergeTwoLinkedList().mergeTwoLists(t1,s1);
        while (newHead != null) {
            System.out.print(newHead.val);
            newHead = newHead.next;
        }
    }
}

/**
 * <p> Definition for singly-linked list.</p>
 */
class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){this.val=val;}
    ListNode(int val,ListNode next){this.val=val;this.next=next;}
}
