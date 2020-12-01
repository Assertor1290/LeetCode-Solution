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

    public static void main(String[] args) {
        int[] arr=new int[]{3,2,3};
        System.out.println(new MajorityElement().majorityElement(arr));
    }
}
