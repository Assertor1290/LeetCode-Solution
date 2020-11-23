/**
 * <p>
 *     You are climbing a staircase. It takes n steps to reach the top.
 *     Each time you can either climb 1 or 2 steps. In how many distinct ways
 *     can you climb to the top?
 * </p>
 */
public class ClimbingStairs {
    /**
     * Brute Force: Recursive approach
     * TC: O(2^n)
     * Sc: O(2^n)
     * @param n steps
     * @return number of distinct ways to reach nth step.
     */
    public int climbStairs(int n){
        if(n<0)
            return 0;
        if(n==0)
            return 1;
        return climbStairs(n-1)+climbStairs(n-2);
    }

    /**
     * Recursive with Memoization
     * TC: O(n)
     * SC: O(n)
     * @param n steps
     * @return number of distinct ways to reach nth step.
     */
    public int climbStairs2(int n) {
        int[] memo = new int[n + 1];
        return climbStairsHelper(n, memo);
    }

    private int climbStairsHelper(int n, int[] memo) {
    /*
      0 distinct ways to climb negative steps if we
      can only take 1 or 2 steps
    */
        if (n < 0) {
            return 0;
        }

    /*
      1 distinct way to climb if we can only take 1
      or 2 steps.
    */
        if (n == 0) {
            return 1;
        }

    /*
      Do we already have an answer to this question (subproblem)?
      If not fall through and compute, BUT if we already know it
      just return it from the cache
    */
        if (memo[n] > 0) {
            return memo[n];
        }

    /*
      The answer to this subproblem is the sum of the answer to the subproblems n - 1 and n - 2
      This drills us towards our base cases that bring us back up with an answer
      We cache the answer before returning it so we have it later
    */
        memo[n] = climbStairsHelper(n - 1, memo) + climbStairsHelper(n - 2, memo);
        return memo[n];
    }

    /**
     *
     * @param n steps
     * @return number of distinct ways to reach nth step.
     */
    public int climbStairs3(int n){

    }

    public static void main(String[] args) {
        System.out.println(new ClimbingStairs().climbStairs(5));
        System.out.println(new ClimbingStairs().climbStairs2(5));
    }
}
