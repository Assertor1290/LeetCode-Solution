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
     * TC:O(1):However as number of bits increases, time increases. SC:O(1)
     * @param n input number
     * @return number  of 1 bits
     */
    public int hammingWeight(int n){
        int mask=1;
        int bits=1;
        for(int i=0;i<32;i++){
            if((n & mask)!=0){
                bits++;
            }
            mask<<=1;
        }
        return bits;
    }
    
    public static void main(String[] args) {
        int n=11;
        System.out.println(new NumberOfOneBits().hammingWeight(n));
    }
}
