/**
 * <p>
 * Given a non-empty array of integers, every element appears twice except for one.
 * Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity.
 * Could you implement it without using extra memory?
 * </p>
 */
public class SingleNumber {
    /**
     *
     * @param nums input array
     * @return unique number
     */
    public int singleNumber3(int[] nums){

    }
    /**
     * If we take XOR of zero and some bit, it will return that bit
     * a ⊕ 0 = a
     * If we take XOR of two same bits, it will return 0
     * a ⊕ a = 0
     * a ⊕ b ⊕ a = (a ⊕ a ) ⊕ b = 0 ⊕ b = b
     * So we can XOR all bits together to find the unique number.
     * Time:O(n) Space:O(1)
     * Runtime:0ms,Memory:40.7MB
     * @param nums input array
     * @return unique number
     */
    public int singleNumber4(int[] nums){
        int num=0;
        for(int i=0;i<nums.length;i++){
            num^=nums[i];
        }
        return num;
    }
    public static void main(String[] args) {
        int[] arr=new int[]{2,2,1,1,5};
        System.out.println(new SingleNumber().singleNumber4(arr));
    }
}
