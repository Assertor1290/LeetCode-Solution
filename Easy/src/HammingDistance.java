/**
 * <p>The Hamming distance between two integers is the number of
 * positions at which the corresponding bits are different.
 * Given two integers x and y, calculate the Hamming distance.</p>
 */
public class HammingDistance {
    /**
     * Runtime:1ms, Memory:38MB
     * @param x first number
     * @param y second number
     * @return hammingDistance
     */
    public int hammingDistance(int x, int y) {
        //XOR is done to find how many bits are different.
        //Bit 1 indicates that the bit positions are different.
        //count is used to count the number of 1
        int temp=x^y,count=0;
        while(temp>0){
            //temp&1 is used to check if last digit is 1 or not
            if((temp&1) ==1)
                count++;

            //unsigned right shift is used to remove last element
            temp=temp>>>1;
        }
        return count;
    }
    public static void main(String[] args) {
        int a=1,b=4;
        System.out.println(new HammingDistance().hammingDistance(a,b));
    }
}
