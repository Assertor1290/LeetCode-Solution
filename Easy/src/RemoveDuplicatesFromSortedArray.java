/**
 * <p>
 *  Given a sorted array nums, remove the duplicates in-place such that
 *  each element appear only once and return the new length.
 *  Do not allocate extra space for another array, you must do this by modifying
 *  the input array in-place with O(1) extra memory.
 * </p>
 */
public class RemoveDuplicatesFromSortedArray {
    /**
     * Method to remove duplicates in an array.
     * According to question, this does not actually remove duplicates from array
     * It simply puts the unique values at front of array
     * Runtime:0ms Memory:41.5MB
     * @param nums input array
     * @return number of unique elements
     */
    public int removeDuplicates(int[] nums){
        /**
         * Approach: Two Pointers method
         * Since the array is already sorted, we can keep two pointers i and j,
         * where j is the slow-runner while i is the fast-runner.
         * As long as nums[i] = nums[j] we increment i to skip the duplicate.
         * When we encounter nums[i] != nums[j] ,the duplicate run has ended
         * so we must copy its value to nums[j + 1]. j is then incremented
         * and we repeat the same process again until i reaches the end of array.
         */
        int j=0;
        for(int i=0;i< nums.length;i++)
            if(nums[i]!=nums[j]) nums[++j]=nums[i];
        return j+1;
    }
    public static void main(String[] args) {
        int[] arr =new int[]{-3,-1,0,0,0,3,3};
        int size=new RemoveDuplicatesFromSortedArray().removeDuplicates(arr);
        for(int i=0;i<size;i++)
            System.out.print(arr[i]+" ");
    }
}
