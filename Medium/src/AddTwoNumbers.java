public class AddTwoNumbers {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){this.val=val;}
    }

    /**
     * Time:2ms Space:39.6MB
     * Time complexity : O(max(m,n)). Assume that m and n represents the length of
     * l1 and l2 respectively, the algorithm above iterates at most max(m,n) times.
     *
     * Space complexity : O(max(m,n)). The length of the new list is at most max(m,n)+1.
     * @param l1 ListNode pointer to first List
     * @param l2 ListNode pointer to second List
     * @return list which represents sum of two lists
     */
    public ListNode addTwoNumbers(ListNode l1,ListNode l2){
        //l3 acts as pointer to Head
        ListNode l3=new ListNode(0);
        int carry=0;
        ListNode cur=l3;
        while (l1!=null || l2!=null){
            //if it not null, take the current value, else take 0
            int x=(l1!=null)?l1.val:0;
            int y=(l2!=null)?l2.val:0;

            int sum=x+y+carry;
            carry=sum/10;
            sum=sum%10;

            cur.next=new ListNode(sum);
            cur=cur.next;

            if(l1!=null) l1=l1.next;
            if(l2!=null) l2=l2.next;
        }
        //if carry is generated on last term
        if(carry>0){
            cur.next=new ListNode(carry);
        }
        return l3.next;
    }
    public static void main(String[] args) {
    }
}
