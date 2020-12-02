

/**
 * <p>
 *      You are a professional robber planning to rob houses along a street.
 *      Each house has a certain amount of money stashed, the only constraint stopping
 *      you from robbing each of them is that adjacent houses have security system connected
 *      and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 *      Given a list of non-negative integers representing the amount of money of each house,
 *      determine the maximum amount of money you can rob tonight without alerting the police.
 * </p>
 */
public class HouseRobber {
    /**
     * Dynamic Programming Solution: Bottom Up
     * Basically, we need to find maximum amount we can rob at ith point
     * @param nums input array
     * @return maximum amount you can rob
     */
    public int rob(int[] nums){
        //If there are zero houses, return 0
        if(nums.length==0)
            return 0;

        //If there is only one house, can rob that house only
        if(nums.length==1)
            return nums[0];

        //If there are two houses, rob the house with more money
        if(nums.length==2)
            return Math.max(nums[0],nums[1]);

        //Dp array: dp[i] represents the maximum amount we can rob upto point i
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<dp.length;i++){
            dp[i]=Math.max(nums[i]+dp[i-2],dp[i-1]);
        }
        return dp[nums.length-1];
    }

    public static void main(String[] args) {
        int []nums=new int[]{2,1,1,2};
        System.out.println(new HouseRobber().rob(nums));
    }
}
