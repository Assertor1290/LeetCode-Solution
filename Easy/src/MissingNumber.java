import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 *     Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
 *     find the one that is missing from the array.
 * </p>
 */
public class MissingNumber {
    /**
     * Gauss Formula
     * Time:O(n)  Space:(1)
     * Runtime:0ms, Memory:39.6MB
     * This method calculates sum of array. Also sum if all elements are present= (n*n+1)/2
     * @param nums input array
     * @return missing number
     */
    public int missingNumber(int[] nums) {
        int sum=0;

        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
        }
        int prod=((nums.length)*(nums.length+1))/2;
        return prod-sum;
    }
    /**
     * Bit manipulation
     * Runtime:0ms, Memory:40.4MB
     * Time:O(n)  Space:O(1)
     *
     * Intuition
     * We can harness the fact that XOR is its own inverse to find the missing element in linear time.
     *
     * Algorithm
     * Because we know that nums contains nn numbers and that it is
     * missing exactly one number on the range [0..n-1],
     * we know that nn definitely replaces the missing number in nums.
     * Therefore, if we initialize an integer to n and XOR it with every index and value,
     * we will be left with the missing number.
     *
     * Consider the following example (the values have been sorted for intuitive convenience, but need not be):
     *
     * Index	0	1	2	3
     * Value	0	1	3	4
     *
     * =4∧(0∧0)∧(1∧1)∧(2∧3)∧(3∧4)
     * =(4∧4)∧(0∧0)∧(1∧1)∧(3∧3)∧2
     * =0∧0∧0∧0∧2
     * =2
     * @param nums input array
     * @return missing number
     */
    public int missingNumber1(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }
    /**
     * HAshSet
     * Time complexity : O(n)
     * Because the set allows for O(1) containment queries, the main loop runs in
     * O(n) time. Creating num_set costs O(n) time, as each set insertion runs in amortized
     * O(1) time, so the overall runtime is O(n+n)=O(n).
     *
     * Space complexity : O(n)
     * nums contains n-1 distinct elements, so it costs O(n) space to store a set containing all of them.
     * Runtime:5ms, Memory:39.7MB
     * @param nums input array
     * @return missing number
     */
    public int missingNumber2(int[] nums) {

            Set<Integer> set=new HashSet<>();
            for(int i=0;i<nums.length;i++){
                set.add(nums[i]);
            }

            int cnt=nums.length+1;
            for(int i=0;i<cnt;i++){
                if(!set.contains(i)) return i;
            }
            return -1;
    }
    /**
     * Brute Force
     * Time complexity :O(nlgn)
     * The only elements of the algorithm that have asymptotically non constant time complexity
     * are the main for loop (which runs in O(n) time), and the sort invocation
     * (which runs in O(nlgn) time for Python and Java). Therefore, the runtime is dominated by sort,
     * and the entire runtime is O(nlgn).
     *
     * Space complexity : O(1) (or O(n))
     * In the sample code, we sorted nums in place, allowing us to avoid allocating additional space.
     * If modifying nums is forbidden, we can allocate an O(n) size copy and sort that instead.
     * Runtime:7ms, Memory:48.6MB
     * @param nums input array
     * @return missing number
     */
    public int missingNumber3(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i)
            {
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        int[] arr=new int[]{3,0,1};
        System.out.println(new MissingNumber().missingNumber(arr));
    }
}
