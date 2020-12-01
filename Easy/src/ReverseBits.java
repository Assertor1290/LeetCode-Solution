/**
 * <p>
 *     Reverse bits of a given 32 bits unsigned integer.
 * </p>
 */
public class ReverseBits {
    /**
     * Using built in function
     * Runtime:0ms
     * @param n input 32 bit number
     * @return reversed 32 bit number
     */
    public int reverseBits(int n){
        return Integer.reverse(n);
    }

    //To understand the following two approaches, refer to the link
    //https://www.youtube.com/watch?v=-5z9dimxxmI&feature=youtu.be
    /**
     * TC:O(32)=O(1), SC:O(!1)
     * @param n input 32 bit number
     * @return reversed 32 bit number
     */
    public int reverseBits2(int n){
        int result=0;
        for(int i=0;i<32;i++){
            result <<=1;
            //result |= n&1
            result += n&1;
            n >>>= 1;
        }
        return result;
    }

    /**
     * This approach is suitable for larger bit number
     * TC:O(1) SC:O(1)
     * @param n input 32 bit number
     * @return reversed 32 bit number
     */
    public int reverseBits3(int n){
        n = (n >>> 16) | (n << 16);
        n = ((n & 0xff00ff00) >>> 8) | ((n & 0x00ff00ff) << 8);
        n = ((n & 0xf0f0f0f0) >>> 4) | ((n & 0x0f0f0f0f) << 4);
        n = ((n & 0xcccccccc) >>> 2) | ((n & 0x33333333) << 2);
        n = ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);
        return n;
    }

    public static void main(String[] args) {
        int n=43261596;
        System.out.println(new ReverseBits().reverseBits(n));
        n = 43261596;
        System.out.println(new ReverseBits().reverseBits2(n));
        n = 43261596;
        System.out.println(new ReverseBits().reverseBits3(n));
    }
}
