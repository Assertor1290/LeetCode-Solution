import java.util.*;

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
     * List Operation
     * Iterate over all the elements in nums
     * If some number in nums is new to array, append it
     * If some number is already in the array, remove it
     * Time:O(n^2): We iterate through nums, taking O(n) time.
     * We search the whole list(contains method) to find whether there is duplicate number,
     * taking O(n) time.
     * Space:O(n)
     * Runtime:584ms, Memory:39.3MB
     * @param nums input array
     * @return unique number
     */
    public int singleNumber1(int[] nums){
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            //if list does not contain the item add it to list
            //else remove it from list
            if(!list.contains(nums[i]))
                list.add(nums[i]);
            else
                list.remove(new Integer(nums[i]));
        }
        //return the only element present in list i.e. unique element
        return list.get(0);
    }

    /**
     * Time complexity : O(n*1)=O(n). Time complexity of for loop is O(n)
     * Time complexity of hash table operation pop is O(1).
     * Space complexity : O(n)
     * The space required by hash table is equal to the number of elements in nums.
     * Runtime:7ms, Memory:40.2MB
     * @param nums input array
     * @return unique number
     */
    public int singleNumber2(int[] nums){
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:nums){
            //Iterate through elements and set up key/value pair
            //We are counting the number of occurrences of each number
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(int i:nums){
            //if count of a number is 1, then return it
            if(map.get(i)==1)
                return i;
        }
        return 0;
    }

    /**
     * 2∗(a+b+c)−(a+a+b+b+c)=c
     * Time complexity : O(n+n)=O(n). sum will call next to iterate through nums.
     * We can see it as sum(list(i, for i in nums)) which means the time complexity
     * is O(n) because of the number of elements(nn) in nums.
     * Space complexity : O(n+n)=O(n). Set needs space for the elements in nums
     * Runtime:4ms Space:39.6MB
     * @param nums input array
     * @return unique number
     */
    public int singleNumber3(int[] nums){
        int totalSum=0,uniqueSum=0;
        Set<Integer> set=new HashSet<>();

        for(int i:nums){
            if(!set.contains(i)){
                set.add(i);
                uniqueSum+=i;
            }
            totalSum+=i;
        }
        return 2*uniqueSum - totalSum;
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
        System.out.println(new SingleNumber().singleNumber1(arr));
        System.out.println(new SingleNumber().singleNumber2(arr));
        System.out.println(new SingleNumber().singleNumber3(arr));
        System.out.println(new SingleNumber().singleNumber4(arr));
    }
}
