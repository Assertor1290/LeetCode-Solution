import java.util.Arrays;

/**
 * <p>
 *     Given an array of integers, find if the array contains any duplicates.
 *     Your function should return true if any value appears at least twice in the array,
 *     and it should return false if every element is distinct.
 * </p>
 */
public class ContainsDuplicate {
    /**
     * Brute force
     * TC:O(n^2) SC:O(1)
     * @param nums input array
     * @return true if duplicates present else false
     */
    public boolean containsDuplicate(int[] nums){
        for (int i = 0; i < nums.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[j] == nums[i]) return true;
            }
        }
        return false;
    }

    /**
     * Sorting
     * TC:O(nlogn) SC:O(1)
     * @param nums input array
     * @return true if duplicates present else false
     */
    public boolean containsDuplicate2(int[] nums){
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] == nums[i + 1]) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr=new int[]{1,2,3,1};
        System.out.println(new ContainsDuplicate().containsDuplicate(arr));
        System.out.println(new ContainsDuplicate().containsDuplicate2(arr));
    }
}
