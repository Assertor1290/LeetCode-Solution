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

    /**
     * Runtime:4ms, Memory:41.4MB
     * @param nums input array
     * @return third maximum number
     */
    public int thirdMax3(int[] nums) {
        Integer max1=null;
        Integer max2=null;
        Integer max3=null;
        for(Integer n:nums){
            if (n.equals(max1) || n.equals(max2) || n.equals(max3)) continue;
            if(max1==null || n>max1){
                max3=max2;
                max2=max1;
                max1=n;
            }
            else if(max2==null || n>max2){
                max3=max2;
                max2=n;
            }
            else if(max3==null || n>max3){
                max3=n;
            }
        }
        return (max3==null)?max1:max3;
    }

    /**
     * Runtime:0ms, Memory:39.7MB
     * @param a
     * @return
     */
    public int thirdMax4(int[] a) {
        int n = a.length;
        long mx1=Long.MIN_VALUE,mx2=Long.MIN_VALUE,mx3=Long.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(a[i]>mx1){
                mx3=mx2;
                mx2=mx1;
                mx1=a[i];
            }
            else if(a[i]>mx2 && a[i]!=mx1){
                mx3=mx2;
                mx2=a[i];
            }
            else if(a[i]>mx3 && a[i]!=mx2 && a[i]!=mx1){
                mx3=a[i];
            }
        }
        if(mx3==Long.MIN_VALUE) return (int)mx1;
        return (int)mx3;
    }
    public static void main(String[] args) {
        int[] arr=new int[]{1,2};
        System.out.println(new ThirdMaximumNumber().thirdMax(arr));
        System.out.println(new ThirdMaximumNumber().thirdMax2(arr));
        System.out.println(new ThirdMaximumNumber().thirdMax3(arr));
        System.out.println(new ThirdMaximumNumber().thirdMax4(arr));

    }
}
