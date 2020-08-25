import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * <p>
 *     Given a non-empty array of integers, return the third maximum number in this array.
 *     If it does not exist, return the maximum number. The time complexity must be in O(n).
 * </p>
 */
public class ThirdMaximumNumber {
    /**
     * A PriorityQueue is used when the objects are supposed to be processed based on the priority.
     * The PriorityQueue is based on the priority heap. The elements of the priority queue are ordered
     * according to the natural ordering, or by a Comparator provided at queue construction time.
     *
     * Head has least element
     * Runtime:8ms, Memory:41.5 MB
     * @param nums input array
     * @return third maximum number
     */
    public int thirdMax(int[] nums){
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int num:nums){
            //if condition avoids duplicates
            if(!pq.contains(num)){
                pq.add(num);
                if(pq.size()>3){
                    //poll removes head of queue
                    pq.poll();
                }
            }
        }
        if(pq.size()==2){
            pq.poll();
        }

        return pq.poll();
    }

    /**
     * Runtime:4ms, Memory:39MB
     * The elements are ordered using their natural ordering, or by a Comparator
     * provided at set creation time, depending on which constructor is used.
     * This implementation provides guaranteed log(n) time cost for the basic
     * operations (add, remove and contains).
     * @param nums input array
     * @return third maximum number
     */
    public int thirdMax2(int[] nums){
        TreeSet<Integer> set=new TreeSet<>();
        for(int i:nums){
            set.add(i);
        }
        if(set.size()<3){
            return set.last();
        }
        set.remove(set.last());
        set.remove(set.last());
        return set.last();
    }
    public static void main(String[] args) {
        int[] arr=new int[]{1,2};
        System.out.println(new ThirdMaximumNumber().thirdMax(arr));
    }
}
