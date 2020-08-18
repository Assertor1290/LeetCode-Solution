import java.util.Arrays;

/**
 * <p>
 *     Given a non-empty array of digits representing a non-negative integer, increment one to the integer.
 * </p>
 */
public class PlusOne {
    /**
     * Runtime:0ms  Memory:37.9MB
     * @param digits the input array
     * @return array after incrementing by 1
     */
    public int[] plusOne(int[] digits){
        int len=digits.length;
        for(int i=len-1;i>=0;i--){
            if(digits[i]<9){
                digits[i]+=1;
                return digits;
            }
            digits[i]=0;
        }
        //when all digits are 9
        int[] newArray=new int[len+1];
        newArray[0]=1;
        //other digits are 0 by default
        return newArray;
    }
    public static void main(String[] args) {
        int[] digits=new int[]{2,4,1};
        System.out.println(Arrays.toString(new PlusOne().plusOne(digits)));
    }
}
