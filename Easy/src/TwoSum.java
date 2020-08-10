import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *     Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * </p>
 */
public class TwoSum {
    /**
     * Method 1: Brute Force O(n^2)
     * Runtime: Memory:
     * @param nums input array of integers
     * @param target the target sum
     * @return array of indices
     */
    public int[] twoSum(int[] nums, int target){
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * Method 2: Hash Table O(n)
     * Runtime: Memory:
     * @param nums input array of integers
     * @param target the target sum
     * @return array of indices
     */
    public int[] twoSums2(int[] nums, int target){
        Map<Integer,Integer> map=new HashMap<>();
        int[] result=new int[2];
        for(int i=0;i<nums.length;i++){
            int temp=target-nums[i];
            if(map.containsKey(temp)){
                result[0]=map.get(temp);
                result[1]=i;
            }
            else{
                map.put(nums[i],i);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr=new int[]{2,7,11,15};
        System.out.println(Arrays.toString(new TwoSum().twoSum(arr, 9)));
        System.out.println(Arrays.toString(new TwoSum().twoSums2(arr, 9)));
    }
}
