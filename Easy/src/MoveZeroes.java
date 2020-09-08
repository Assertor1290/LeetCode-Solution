import java.util.Arrays;

/**
 * <p>
 *     Given an array nums, write a function to move all 0's to
 *     the end of it while maintaining the relative order of the non-zero elements.
 * </p>
 */
public class MoveZeroes {
    /**
     * Time:O(n) Space:O(n)
     * Runtime:0ms, Memory:40.2MB
     * @param nums input array
     */
    public void moveZeroes(int[] nums){
        int cntZeroes=0;
        int n=nums.length;
        //loop to count number of zeroes
        for(int i=0;i<n;i++){
            if(nums[i]==0)
                cntZeroes++;
        }

        int arr[]=new int[n];
        int j=0;
        //Move non zero elements to another array
        for(int i=0;i<n;i++){
            if(nums[i]!=0){
                arr[j]=nums[i];
                j++;
            }
        }

        //fill remaining elements with 0
        for (int i = 0; i < cntZeroes; i++) {
            arr[j]=0;
            j++;
        }

        //Now, we have to modify original array, hence
        //copy from new array to old array
        for (int i = 0; i < n; i++) {
            nums[i] = arr[i];
        }
    }
    /**
     * Time:O(n) Space:O(1)
     * Runtime:0ms, Memory:39.7MB
     * Space Optimal
     * The above problem can also be stated in alternate way,
     * "Bring all the non 0 elements to the front of array keeping their relative order same".
     * This is a 2 pointer approach. The fast pointer which is denoted by variable "cur"
     * does the job of processing new elements. If the newly found element is not a 0,
     * we record it just after the last found non-0 element.
     * The position of last found non-0 element is denoted by the slow pointer
     * "lastNonZeroFoundAt" variable. As we keep finding new non-0 elements,
     * we just overwrite them at the "lastNonZeroFoundAt + 1" 'th index.
     * This overwrite will not result in any loss of data because we
     * already processed what was there(if it were non-0,it already is now
     * written at it's corresponding index,or if it were 0 it will be handled later in time).
     *
     * After the "cur" index reaches the end of array, we now know that all
     * the non-0 elements have been moved to beginning of array in their original order.
     * Now comes the time to fulfil other requirement, "Move all 0's to the end".
     * We now simply need to fill all the indexes after the "lastNonZeroFoundAt" index with 0.
     * @param nums input array
     */
    public void moveZeroes2(int[] nums) {
        int lastNonZero=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]!=0)
                nums[lastNonZero++]=nums[i];
        }
        for(int i=lastNonZero;i<n;i++){
            nums[i]=0;
        }
    }
    public static void main(String[] args) {
        int[] nums=new int[]{0,1,0,3,12};
        new MoveZeroes().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
