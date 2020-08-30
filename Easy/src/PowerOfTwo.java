/**
 * <p>
 *     Given an integer, write a function to determine if it is a power of two.
 * </p>
 */
public class PowerOfTwo {
    /**
     * Runtime:1ms, Memory:36.6MB
     * @param n input integer
     * @return true or false
     */
    public boolean isPowerOfTwo(int n) {

        int i=0;
        while(Math.pow(2,i)<=n){

            if(Math.pow(2,i)==n) return true;
            i++;
        }
        return false;
    }
    /**
     * Runtime:1ms, Memory:36.5MB
     * The idea is that a power of two in binary form has only one "1".
     * @param n input integer
     * @return true or false
     */
    public boolean isPowerOfTwo2(int n){

        return n>0 && Integer.bitCount(n) == 1;
    }
    /**
     * Runtime:2ms, Memory:38.8MB
     * Observe the pattern
     *               BINARY REPRESENTATION
     *      POWER Of TWO          NUMBER ONE LESS THAN POWER OF 2
     *      2^0 = 1  = 1                  1-1 = 0  = 0
     *      2^1 = 2  = 10                 2-1 = 1  = 1
     *      2^2 = 4  = 100                4-1 = 3  = 11
     *      2^3 = 8  = 1000               8-1 = 7  = 111
     *      2^4 = 16 = 10000             16-1 = 15 = 1111
     *      2^5 = 32 = 100000            32-1 = 31 = 11111
     *      2^6 = 64 = 1000000           64-1 = 63 = 111111
     *
     *      As we can see from pattern (n&n-1) is 0 when n is power of 2.
     *
     * @param n input integer
     * @return true or false
     */
    public boolean isPowerOfTwo3(int n){

        return n>0 && Integer.bitCount(n) == 1;
    }
    public static void main(String[] args) {
        int n=4;
        System.out.println(new PowerOfTwo().isPowerOfTwo(n));
        System.out.println(new PowerOfTwo().isPowerOfTwo2(n));
        System.out.println(new PowerOfTwo().isPowerOfTwo3(n));
    }
}
