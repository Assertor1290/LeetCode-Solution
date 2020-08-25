import java.util.PriorityQueue;

/**
 * <p>
 *     Given a non-empty array of integers, return the third maximum number in this array.
 *     If it does not exist, return the maximum number. The time complexity must be in O(n).
 * </p>
 */
public class ThirdMaximumNumber {
    public int thirdMax(int[] nums){
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int num:nums){
            if(!pq.contains(num)){
                pq.add(num);
                if(pq.size()>3){
                    pq.poll();
                }
            }
        }
        if(pq.size()==2){
            pq.poll();
        }

        return pq.poll();
    }
    public static void main(String[] args) {
        int[] arr=new int[]{3,2,5,6,1,2};
        System.out.println(new ThirdMaximumNumber().thirdMax(arr));
    }
}
