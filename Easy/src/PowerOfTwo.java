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
     * @param n input integer
     * @return true or false
     */
    public boolean isPowerOfTwo2(int n){

        return n>0 && Integer.bitCount(n) == 1;
    }
    public static void main(String[] args) {
        int n=4;
        System.out.println(new PowerOfTwo().isPowerOfTwo(n));
        System.out.println(new PowerOfTwo().isPowerOfTwo2(n));
    }
}
