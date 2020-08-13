/**
 * <p>
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 * </p>
 */
public class SearchInsertPosition {
    /**
     * eg: nums:1 2 3 4 5 6, target=5
     * i=4 :nums[4]=5<5 false return 4
     *
     * nums: 1 2 3 4 6, target=5
     * i=4 :nums[4]=6>5 false return 4
     * @param nums input array
     * @param target the value to search
     * @return index of value if present or where it has to be inserted
     */
    public int searchInsert(int[] nums,int target){
        int i=0;
        while(i< nums.length && nums[i]<target){
            i++;
        }
        return i;
    }
    public static void main(String[] args) {
        int[] arr=new int[]{1,3,5,6};
        int target=5;
        System.out.println(new SearchInsertPosition().searchInsert(arr,target));
    }
}
