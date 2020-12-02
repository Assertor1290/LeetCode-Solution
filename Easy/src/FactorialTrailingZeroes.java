/**
 * <p>
 *     Given an integer n, return the number of trailing zeroes in n!.
 *     Follow up: Could you write a solution that works in logarithmic time complexity?
 * </p>
 */
public class FactorialTrailingZeroes {

    /**
     * An efficient way to identify the occurences of 5 as a multiplier in the preceding numbers
     * of the sequence is by dividing n by 5 and then dividing it's result by 5 again until
     * you get a result smaller than 5
     * https://www.youtube.com/watch?v=GokjSyb-Z_c
     * @param n input number
     * @return number of trailing zeroes
     */
    public int trailingZeroes(int n) {
        int result = 0;
        // stop dividing when you get a result less than 5
        while (n >= 5) {
            //add the result of n/5 to the counter - since we're using integers we don't need to worry about decimals
            result += n/5;
            // replace n with n/5 so that we can divide it by 5 in the next iteration
            n = n/5;
        }
        return result;
    }

    public static void main(String[] args) {
        int n=21;
        System.out.println(new FactorialTrailingZeroes().trailingZeroes(n));
    }
}
