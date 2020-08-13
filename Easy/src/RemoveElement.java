/**
 * Given an array nums and a value val, remove all instances of that
 * value in-place and return the new length. Do not allocate extra space
 * for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length
 */
public class RemoveElement {
    /**
     * Approach: Two Pointer method
     * When nums[i] equals to the given value, skip this element by incrementing i.
     * As long as nums[i] != val we copy nums[i] to nums[j] and increment both indexes
     * at the same time. Repeat the process until i reaches the end of the array and the new length is j.
     * Runtime:0ms, Memory:38.1MB
     * @param nums the input array
     * @param val value to be removed
     * @return new length
     */
    public int removeElement(int[] nums,int val){
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[j]=nums[i];
                j++;
            }
        }
        return j;
    }

    /**
     * Approach 2: Two Pointers - when elements to remove are rare
     * When we encounter nums[i] = val we can swap the current
     * element out with the last element and dispose the last one.
     * This essentially reduces the array's size by 1.
     * Runtime:0ms, Memory:38.4MB
     * @param nums the input array
     * @param val value to be removed
     * @return new length
     */
    public int removeElement2(int[] nums,int val){
        int i=0;
        int n=nums.length;
        while(i<n){
            if(nums[i]==val){
                nums[i]=nums[n-1];
                n--;
            }
            else{
                i++;
            }
        }
        return i;
    }
    public static void main(String[] args) {
        int[] arr1=new int[]{3,2,2,3};
        int[] arr2=new int[]{0,1,2,2,3,0,4,2};
        int n1=new RemoveElement().removeElement(arr1,3);
        int n2=new RemoveElement().removeElement2(arr2,2);
        for(int i=0;i<n1;i++)
            System.out.print(arr1[i]);
        System.out.println();
        for(int i=0;i<n2;i++)
            System.out.print(arr2[i]);
    }
}
