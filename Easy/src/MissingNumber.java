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
     * Gauss Formula
     * Time:O(n)  Space:(1)
     * Runtime:0ms, Memory:39.6MB
     * This method calculates sum of array. Also sum if all elements are present= (n*n+1)/2
     * @param nums input array
     * @return missing number
     */
    public int missingNumber2(int[] nums) {
        int sum=0;

        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
        }
        int prod=((nums.length)*(nums.length+1))/2;
        return prod-sum;
    }
    /**
     * Gauss Formula
     * Time:O(n)  Space:(1)
     * Runtime:0ms, Memory:39.6MB
     * This method calculates sum of array. Also sum if all elements are present= (n*n+1)/2
     * @param nums input array
     * @return missing number
     */
    public int missingNumber3(int[] nums) {
        int sum=0;

        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
        }
        int prod=((nums.length)*(nums.length+1))/2;
        return prod-sum;
    }

    public static void main(String[] args) {
        int[] arr=new int[]{3,0,1};
        System.out.println(new MissingNumber().missingNumber(arr));
    }
}
