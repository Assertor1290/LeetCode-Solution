import java.util.Arrays;

/**
 * <p>
 *     Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
 *     Return the array in the form [x1,y1,x2,y2,...,xn,yn].
 * </p>
 */
public class ShuffleTheArray {

    /**
     * Runtime: 0ms, Memory:39.7MB
     * @param nums input array
     * @param n half length of nums
     * @return final array
     */
    public int[] shuffle(int[] nums, int n) {
        int[] answer=new int[2*n];

        int j=0;
        //place first half of input array in 0,2,4 i.e even index
        for(int i=0;i<n;i++){
            answer[j]=nums[i];
            j+=2;
        }
        j=1;
        //place next half in 1,3,5,  i.e. odd index
        for(int i=n;i<(2*n);i++){
            answer[j]=nums[i];
            j+=2;
        }
        return answer;
    }
    public static void main(String[] args) {
        int []nums=new int[]{2,5,1,3,4,7};
        int n=3;
        System.out.println(Arrays.toString(new ShuffleTheArray().shuffle(nums, 3)));
    }
}
