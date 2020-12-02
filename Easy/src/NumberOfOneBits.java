/**
 * <p>
 *  Write a function that takes an unsigned integer and returns the number of '1' bits it has
 *  Follow up: If this function is called many times, how would you optimize it?
 * </p>
 */
public class NumberOfOneBits {
    /**
     * The solution is straight-forward. We check each of the 32 bits of the number.
     * If the bit is 1, we add one to the number of 1-bits.
     *
     * We can check the ith bit of a number using a bit mask.
     * We start with a mask m=1, because the binary representation of 1 is,
     *
     * 00000000 00000000 00000000 00000001
     * Clearly, a logical AND between any number and the mask 1
     * gives us the least significant bit of this number.
     * To check the next bit, we shift the mask to the left by one.
     * TC:O(1) SC:O(1)
     * @param n input number
     * @return number  of 1 bits
     */
    public int hammingWeight(int n){
        int mask=1;
        int bits=0;
        for(int i=0;i<32;i++){
            //checking if bit is 1 or 0.
            //1&1=1 0&1=0
            if((n & mask)!=0){
                bits++;
            }
            mask<<=1;
        }
        return bits;
    }

    /**
     * Instead of checking every bit of the number, we repeatedly flip the least-significant
     * 1-bit of the number to 0, and add 1 to the sum. As soon as the number becomes 0,
     * we know that it does not have any more 1-bits, and we return the sum.
     *
     * The key idea here is to realize that for any number n, doing a bit-wise AND of n and n - 1
     * flips the least-significant 1-bit in n to 0.
     * TC:O(1) SC:O(1)
     * @param n input number
     * @return number  of 1 bits
     */
    public int hammingWeight2(int n){
        int sum=0;
        while (n!=0){
            sum++;
            n &= n-1;
        }
        return sum;
    }

    public static void main(String[] args) {
        int n=11;
        System.out.println(new NumberOfOneBits().hammingWeight(n));
        System.out.println(new NumberOfOneBits().hammingWeight2(n));
    }
}
