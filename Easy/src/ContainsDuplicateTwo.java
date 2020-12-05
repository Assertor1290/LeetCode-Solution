import java.util.HashMap;

/**
 * <p>
 *      Given an array of integers and an integer k, find out whether there are
 *      two distinct indices i and j in the array such that nums[i] = nums[j]
 *      and the absolute difference between i and j is at most k.
 * </p>
 */
public class ContainsDuplicateTwo {

    /**
     * @param nums input array
     * @param k atmost difference between index
     * @return true if duplicate is within k indexes
     */
    public boolean containsNearbyDuplicate(int[] nums, int k){
        // Define a hashMap to store the pair of keyValue and indexValue
        HashMap<Integer,Integer> hmap=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            // Check if the current element or nums[i] already stored in hashMap
            if(hmap.containsKey(nums[i])){
                // Count the absolute difference between i & j
                // (by retrieving indexValue of keyValue nums[i] in hashMap).
                // Then check if the difference is less or equal than k
                if (i - hmap.get(nums[i]) <= k){
                    return true;
                }
            }
            // Add or Update the mapNums element
            hmap.put(nums[i],i);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{1,2,3,1};
        int k=3;
        System.out.println(new ContainsDuplicateTwo().containsNearbyDuplicate(nums,k));
    }
}
