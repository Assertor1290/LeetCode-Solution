/**
 * <p>
 *     Given an integer, write a function to determine if it is a power of three.
 *     Could you do it without using any loop / recursion?
 * </p>
 */
public class PowerOfThree {
    /**
     * Runtime:10ms, Memory:39.3MB
     * One simple way of finding out if a number n is a power of a number b is
     * to keep dividing n by b as long as the remainder is 0. This is because we can write
     * n = b^x
     * n = b * b * b.... * b
     *
     * @param n input number
     * @return true or false
     */
    public boolean isPowerOfThree(int n){
        if (n < 1) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
    public static void main(String[] args) {
        System.out.println(new PowerOfThree().isPowerOfThree(6));
    }
}
