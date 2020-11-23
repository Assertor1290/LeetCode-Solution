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
     *
     * @param n steps
     * @return number of distinct ways to reach nth step.
     */
    public int climbStairs2(int n){

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
    }
}
