/**
 * <p>Given a 32-bit signed integer, reverse digits of an integer.</p>
 * <p>Assume we are dealing with an environment which could only store integers
 * within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem,
 * assume that your function returns 0 when the reversed integer overflows.</p>
 */
public class ReverseInteger {
    /**
     * Method returns reverse of given Integer
     * Runtime :1ms Memory:36.8MB
     * @param x THe integer to be reversed
     * @return the reverse of number
     */
    public int reverseInteger(int x){
        //reverse
        int rev=0;
        //remainder
        int rem;
        while(x!=0){
            rem=x%10;
            /**
             * Now, Integer.MAX_VALUE=2^31-1 = 2147483647 and Integer.MIN_VALUE=-2^31 = -2147483648
             * when we do rev=rev*10+rem, overflow can occur.
             * eg: CASE 1: rev>Integer.MAX_VALUE/10
             *             rev=214748365     rev=rev*10=214783650 which overflows the max value.
             *     CASE 2: rev<Integer.MIN_VALUE/10
             *             rev=-214748365     rev=rev*10=-214783650 which overflows the min value.
             *     CASE 3: rev==Integer.MAX_VALUE/10
             *             rev=214748364     rev=rev*10=214783640 now if rem>7, then rev will overflow
             *     CASE 4: rev==Integer.MIN_VALUE/10
             *             rev=-214748364     rev=rev*10=-214783640 now if rem<-8 then rev will overflow.
             */
            if(rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE/10 && rem > 7))
                return 0;
            if(rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && rem < -8))
                return 0;
            rev=rev*10+rem;
            x=x/10;
        }
        return rev;
    }
    public static void main(String[] args) {
        System.out.println(new ReverseInteger().reverseInteger(123));
    }
}
