public class MaximumSubarray{
    /**
     * O(n^3) solution  TLE
     * For each element, we construct all possible subarrays starting from this element.
     * Totally there are at most N^2 subarrays. Also, calculating the sum of each subarray takes O(N).
     * eg:
     *      -2  1  -3  4  -1  2  1  -5  4
     *      left=-2
     *      right=-2 Now, we keep left fixed and move right to end of array.
     *      When the right hits the end, we close the left and move it one index forward
     *      and bring right back to left.
     *
     *      That is, we construct the following subarrays:-
     *      [-2]
     *      [-2  1]
     *      [-2  1  -3]
     *      .
     *      .
     *      .
     *      [-2  1  -3  4  -1  2  1  -5]
     *      [-2  1  -3  4  -1  2  1  -5  4]
     *      This subarray construction is done using two loops
     *
     *      For each subarray we calculate the sum:
     *      [-2]                            =-2
     *      [-2  1]                         =-1
     *      [-2  1  -3]                     =-4
     *      [-2  1  -3  4]                  = 0
     *      [-2  1  -3  4  -1]              =-1
     *      [-2  1  -3  4  -1  2]           = 1
     *      [-2  1  -3  4  -1  2  1]        = 2
     *      [-2  1  -3  4  -1  2  1  -5]    =-3
     *      [-2  1  -3  4  -1  2  1  -5  4] = 1
     *
     *      So max sum in these possible subarray STARTING at index 0 is 2
     *
     *      Now, we have investigated all possible subarrays starting at index 0
     *      Now, we increment left
     *      left=1
     *      right=left=1
     *
     *      similarly we, construct all possible subarrays starting at index 1,
     *      keep finding the sum and comparing it with maxSum
     *
     *      Outer 2 loops to investigate all possible windows
     *      We plant at each 'left' value and explore every 'right' value from that 'left' planting.
     * @param nums the input array
     * @return maximum subarray sum
     */
    public int maxSubArray(int[] nums) {

        int max_sum=Integer.MIN_VALUE;
        for(int left=0;left<nums.length;left++){
            for(int right=left;right<nums.length;right++){
                int subarray_sum=0;
                //equal to because of 1st and last element
                for(int k=left;k<=right;k++){
                    subarray_sum=subarray_sum+nums[k];
                }
                max_sum=Math.max(max_sum,subarray_sum);
            }
        }
        return max_sum;

    }

    /**
     * O(n^2) solution
     * Problem in above code:
     * Consider the point where we are calculating the sum:
     *      [-2]                            =-2
     *      [-2  1]                         =-1
     *      [-2  1  -3]                     =-4
     *      [-2  1  -3  4]                  = 0
     *      [-2  1  -3  4  -1]              =-1
     *      [-2  1  -3  4  -1  2]           = 1
     *      [-2  1  -3  4  -1  2  1]        = 2
     *      [-2  1  -3  4  -1  2  1  -5]    =-3
     *      [-2  1  -3  4  -1  2  1  -5  4] = 1
     *
     *      So to calculate sum of subarray, we are going back to extreme left and then
     *      doing the sum from there
     *
     *      eg: to calculate sum of [-2 1 -3 4] we start from all the way back from -2 and go to 4
     *      but we had already calculated the sum upto [-2 1 -3]
     *      So in this solution, instead of going back to left, we use previous sum to calculate the new sum
     *      i.e sum[-2 1 -3 4]= sum[-2 1 -3] + 4
     * @param nums input array
     * @return maximum subarray sum
     */
    public int maxSubArray1(int[] nums) {

        int max_sum=Integer.MIN_VALUE;
        for(int left=0;left<nums.length;left++){
            int subarray_sum=0;
            for(int right=left;right<nums.length;right++){

                subarray_sum=subarray_sum+nums[right];
                max_sum=Math.max(max_sum,subarray_sum);
            }
        }
        return max_sum;
    }
    
    public int maxSubArray2(int[] nums) {

    }
    public int maxSubArray3(int[] nums) {

    }
    public static void main(String[] args) {

    }
}
