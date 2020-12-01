import java.util.Arrays;
import java.util.HashMap;

/**
 * <p>
 *      Given an array of size n, find the majority element.
 *      The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 *
 *      You may assume that the array is non-empty and the majority element always exist in the array.
 * </p>
 */
public class MajorityElement {
    /**
     * Brute force
     * The brute force algorithm iterates over the array, and then iterates again
     * for each number to count its occurrences. As soon as a number is found to have
     * appeared more than any other can possibly have appeared, return it.
     * TC:O(n^2) SC:O(1)
     * @param nums input array
     * @return majorityElement
     */
    public int majorityElement(int[] nums) {
        int majorityCount = nums.length/2;

        for (int num : nums) {
            int count = 0;
            for (int elem : nums) {
                if (elem == num) {
                    count += 1;
                }
            }
            if (count > majorityCount) {
                return num;
            }
        }
        return -1;
    }

    /**
     * HashMap
     * We can use a HashMap that maps elements to counts in order to count
     * occurrences in linear time by looping over nums.
     * Then, we simply return the key with maximum value.
     * TC:O(n) SC:O(n)
     * @param nums input array
     * @return majorityElement
     */
    public int majorityElement2(int[] nums) {
        int ans=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int key:map.keySet()){
            if(map.get(key)>nums.length/2){
                ans=key;
            }
        }
        return ans;
    }

    /**
     * Sorting
     *         if element occurs more than n/2 its guaranteed to be a middle element if sorted
     *         eg 1(0)  .... x(n/2) ......(n)
     * TC:O(nlogn) SC:O(1)
     * @param nums input array
     * @return majorityElement
     */
    public int majorityElement3(int[] nums) {

        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    /**
     * Boyer-Moore Voting Algorithm
     * Start by assuming that the first element of the array is the majority element.
     * Have a counter variable to count its frequency. As you traverse through the array,
     * if the current element of the array is same as the majority element,
     * increment the counter variable and move ahead.
     * If the current element is not same as the majority element,
     * you need to nullify one vote of the majority element.
     * So, decrement the counter variable if the counter is not already 0.
     * If the counter is zero, reset the majority element to the current element
     * and increment the counter. You will end up with the majority element once the iteration is done.
     * TC:O(n) SC:O(1)
     * @param nums input array
     * @return majorityElement
     */
    public int majorityElement4(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

    public static void main(String[] args) {
        int[] arr=new int[]{3,2,3};
        System.out.println(new MajorityElement().majorityElement(arr));
        System.out.println(new MajorityElement().majorityElement2(arr));
        System.out.println(new MajorityElement().majorityElement3(arr));
        System.out.println(new MajorityElement().majorityElement4(arr));
    }
}
