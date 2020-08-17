public class MaximumSubarray{
    /**
     * Time: O(n^3) solution Space: O(1) TLE
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
     * O(n^2) solution  Space:O(1)
     * Runtime: 131ms Memory:39.3MB
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

    /**
     * O(n) O(1)
     * Runtime:1ms, Memory:39.4MB
     * Kadane's Algorithm/ DP
     * Kadane's Algorithm is an O(n) algorithm for finding the maximum
     * contiguous subsequence in a one-dimensional sequence.
     * The algorithm keeps track of the tentative maximum subsequence in (maxSum, maxStartIndex, maxEndIndex).
     * It accumulates a partial sum in currentMaxSum and updates the optimal range when this partial sum becomes larger than maxSum.
     * How to turn it into Linear Time?
     *
     * We are inspecting the item at index i.
     * We want to answer the question:
     * "What is the Max Contiguous Subarray Sum we can achieve ending at index i?"
     *
     * We have 2 choices:1) either start at the current index or 2)add the current element to the previous sum
     * i.e.
     * 1) maxEndingHere + nums[i] (extend the previous subarray best whatever it was) or 2) nums[i] (current item)
     * The max of these 2 choices will be the best answer to the Max Contiguous
     * Subarray Sum we can achieve for subarrays ending at index i.
     *
     *         Example:
     *
     *         index     0  1   2  3   4  5  6   7  8
     *         Input: [ -2, 1, -3, 4, -1, 2, 1, -5, 4 ]
     *                  -2, 1, -2, 4,  3, 5, 6,  1, 5    'maxEndingHere' at each point
     *
     *         The best subarrays we would take if we took them:
     *           ending at index 0: [ -2 ]           (snippet from index 0 to index 0)
     *           ending at index 1: [ 1 ]            (snippet from index 1 to index 1) [we just took the item at index 1]
     *           ending at index 2: [ 1, -3 ]        (snippet from index 1 to index 2)
     *           ending at index 3: [ 4 ]            (snippet from index 3 to index 3) [we just took the item at index 3]
     *           ending at index 4: [ 4, -1 ]        (snippet from index 3 to index 4)
     *           ending at index 5: [ 4, -1, 2 ]     (snippet from index 3 to index 5)
     *           ending at index 6: [ 4, -1, 2, 1 ]  (snippet from index 3 to index 6)
     *           ending at index 7: [ 4, -1, 2, 1, -5 ]    (snippet from index 3 to index 7)
     *           ending at index 8: [ 4, -1, 2, 1, -5, 4 ] (snippet from index 3 to index 8)
     *
     * (Some thought -- when facing "consecutive sequence problems" such as subarray or substring,
     * the subproblems usually MUST END WITH current element, so that when NEXT element comes,
     * the sequence will still remain consecutive).
     * @param nums input array
     * @return the maximum sum
     */
    public int maxSubArray2(int[] nums) {
        int max_sum=nums[0];
        int maxEndingHere=nums[0];
        for(int i=1;i<nums.length;i++){
            //max(continue max subarray with the current item, start new subarray with current item)
            maxEndingHere=Math.max(maxEndingHere+ nums[i],nums[i]);
            max_sum=Math.max(maxEndingHere,max_sum);
        }
        return max_sum;
    }

    /**
     * O(NlogN)
     * Runtime:2ms  Memory:39.2MB
     * Divide and Conquer
     * There are three possibilities for any subarray:
     * 1)Subaaray lies completely in left side
     * 2)Subarray lies completely in right half
     * 3)Subarray crosses the half i.e( some part in left half sand some part oin right half)
     *
     * Go towards left from center and find the best/max sum and note its position
     * Similarly, go to right from center and find best/max sum and note its position
     * Then add those sums: This is the crossum
     *
     * Now compare the values of leftsum, rightsum, crosssum
     * Algo:
     *
     *      Max Subaarray(A,p,r)
     *
     *      if p==r  return A[p]
     *      q=(p+r)/2  OR p+(r-p)/2
     *      L=Max Subarray(A,p,q-1)
     *      R=Max Subarray(A,q+1,r)
     *      C=Max Crossing Subarray(A,p,q,r)
     *      return Max(L,R,C)
     *
     *   eg:                [-2  -5  6  -2 | -3  1  5  -6]
     *                           /                \
     *                          /                  \
     *                  [-2  -5  6  -2]       [-3  1  5  -6]
     * max(Lss, Rss, Css)  > /    \                 /   \
     *       = -2         ( /      \               /     \
     *                   CSS -7
     *                  [-2  -5]  [6  -2]      [-3  1]  [5  -6]
     *        Lss -2  > /   \RSS -5/   \         /  \    /  \
     *               ( /     \    /     \       /    \  /    \
     *                -2    -5   6      -2     -3    1  5    -6
     *
     * @param nums input array
     * @return the maximum sum
     */
    public int maxSubArray3(int[] nums) {
        int n = nums.length;
        return maxSubArray3(nums, 0, n - 1);
    }

    private int maxSubArray3(int[] nums, int lo, int hi) {
        if (lo == hi) { // base case: one number
            return nums[lo];
        }
        // divide
        int mid = lo + (hi - lo) / 2;

        // conquer
        int leftSum = maxSubArray3(nums, lo, mid);
        int rightSum = maxSubArray3(nums, mid + 1, hi);

        // combine
        int crossSum = crossSum(nums, lo, hi);
        return Math.max(crossSum, Math.max(leftSum, rightSum));
    }

    // invariant: lo < hi (left part and right part both have at least 1 element
    private int crossSum(int[] nums, int lo, int hi) {

        int mid = lo + (hi - lo) / 2;
        //left
        int leftSum = 0, leftMax = Integer.MIN_VALUE; // the invariant means that           leftMax and rightMax will be updated
        for (int i = mid; i >= lo; --i) {
            leftSum += nums[i];
            leftMax = Math.max(leftMax, leftSum);
        }
        // right
        int rightSum = 0, rightMax = Integer.MIN_VALUE;
        for (int i = mid + 1; i <= hi; ++i) {
            rightSum += nums[i];
            rightMax = Math.max(rightMax, rightSum);
        }
        return leftMax + rightMax;
    }
    public static void main(String[] args) {
        int[] nums=new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new MaximumSubarray().maxSubArray(nums));
        System.out.println(new MaximumSubarray().maxSubArray1(nums));
        System.out.println(new MaximumSubarray().maxSubArray2(nums));
        System.out.println(new MaximumSubarray().maxSubArray3(nums));
    }
}
