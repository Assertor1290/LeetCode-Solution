import java.util.Arrays;

/**
 * <p>
 *     Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
 *     Return the array in the form [x1,y1,x2,y2,...,xn,yn].
 *     Constraints:
 *          1 <= n <= 500
 *          nums.length == 2n
 *          1 <= nums[i] <= 10^3
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

    /**
     * Runtime: 0ms, Memory:39.8MB
     *
     * Some bit manipulation knowledge will be helpful in understanding this algorithm. This algorithm uses:
     *
     * * Bitwise AND &
     * * Bitwise OR |
     * * Left Shift <<
     * * Right Shift >>
     * * Binary Representations of Numbers
     *
     * This in-place algorithm relies on the constraint 1 <= nums[i] <= 10^3.
     * This means the largest possible number in the nums array is 1000.
     * The binary representation of 1000 is 1111101000.
     * If we count the number of bits in 1111101000 we get 10.
     * Because the largest possible number only uses 10 bits, we can fit two numbers into one 32-bit binary representation.
     * This means we can store pairs of numbers in one binary representation without fear of overwriting a number.
     *
     * Implementation:
     * As shown in the description of the problem, the array starts in the form [x1,x2,...,xn,y1,y2,...,yn]
     *
     * This algorithm will use two loops:
     * Loop 1 will group the numbers into pairs [x1, y1], [x2, y2]... [xn,yn] by storing both numbers xn and yn in one binary representation.
     * Loop 2 will then place these pairs in their final position.
     *
     * We will use two pointers i and j:
     * i will traverse backwards from n to 0.
     * j will traverse backwards from the end of the array to n.
     *
     * Store both nums[i] and nums[j] in nums[j].
     *
     * Because nums[j] is already storing its number we do not need to add it. Instead we need to left shift this number over by 10 bits to make room to add the second number nums[i]. We shift it over by 10 bits because the largest possible number is 1000 which uses 10 bits.
     * nums[j] <<= 10
     * Two add nums[i] we can Bitwise OR nums[i] with nums[j]:
     * nums[j] |= nums[i]
     *
     * Loop 1:
     *
     * When using the following input, Loop 1 will look like the example below:
     * nums = [1,2,3,4,4,3,2,1], n = 4
     *
     * Notes:
     *
     * In the below example [2,3] represents the two numbers 2 and 3 stored in one binary representation.
     * The reason we traverse backwards and store the pairs in the last n numbers is so that when we do a forward traversal for Loop 2 to place numbers in their final place we do not overwrite numbers along the way.
     *       i       j
     * 1 2 3 4 4 3 2 1
     *
     *     i       j
     * 1 2 3 4 4 3 2 [1,4]
     *
     *
     *   i       j
     * 1 2 3 4 4 3 [2,3] [1,4]
     *
     * i       j
     * 1 2 3 4 4 [3,2] [2,3] [1,4]
     *
     * 1 2 3 4 [4,1] [3,2] [2,3] [1,4]
     *
     * Loop 2:
     * Loop 2 will now place numbers in the final position.
     *
     * We will use two pointers i and j.
     * i will traverse forwards from 0 to n.
     * j will traverse forwards from n to the end of the array.
     *
     * The final numbers for positionsnums[i] and nums[i + 1] can be found in the binary representation at nums[j].
     *
     * Get both numbers from nums[j] and update nums[i] and nums[i + 1]
     * Increment i by 2 to place the next pair.
     * Increment j by 1 to get the numbers for the next two positions nums[i] and nums[i + 1]
     * How do we get the two numbers out of nums[j]?
     *
     * To get the first number we will Bitwise AND nums[j] with 1023. We use 1023 because the largest possible number is 1000 which uses 10 bits. 10 bits of all 1s is 1111111111 which is the binary representation of 1023. Bitwise AND with 1023 will cancel out any number after the first 10 bits and we'll be left with the first number only.
     * const num1 = nums[j] & 1023
     * To get the second number we right shift the number back over 10 places.
     * const num2 = nums[j] >> 10
     *
     * @param nums input array
     * @param n half length of nums
     * @return final array
     */
    public int[] shuffle2(int[] nums, int n) {
        int i = n - 1;
        for (int j = nums.length - 1; j >= n; j--) {
            nums[j] <<= 10;
            nums[j] |= nums[i];
            i--;
        }

        i = 0;
        for (int j = n; j < nums.length; j++) {
            int num1 = nums[j] & 1023;
            int num2 = nums[j] >> 10;
            nums[i] = num1;
            nums[i + 1] = num2;
            i += 2;
        }

        return nums;
    }
    public static void main(String[] args) {
        int []nums=new int[]{2,5,1,3,4,7};
        int n=3;
        System.out.println(Arrays.toString(new ShuffleTheArray().shuffle(nums, n)));
        System.out.println(Arrays.toString(new ShuffleTheArray().shuffle2(nums, n)));
    }
}
