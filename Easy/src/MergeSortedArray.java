/**
 * <p>
 *     Given two sorted integer arrays nums1 and nums2,
 *     merge nums2 into nums1 as one sorted array.
 * </p>
 */
public class MergeSortedArray {
    /**
     *
     * @param nums1 first input array
     * @param m number of elements in nums1
     * @param nums2 second input array
     * @param n number of element in second array
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m+n-1;
        int first = m-1;
        int second = n-1;
        //while elelments are present in both the arrays.
        while(first >= 0 || second >= 0){
            int num1 = first >= 0 ? nums1[first] : Integer.MIN_VALUE;
            int num2 = second >= 0 ? nums2[second] : Integer.MIN_VALUE;
            //placing values in nums1 from last index.
            if(num1 > num2){
                nums1[index] = num1;
                first--;
            }else{
                nums1[index] = num2;
                second--;
            }
            index--;
        }
    }
    public static void main(String[] args) {
        int[] nums1=new int[]{1,3,5,0,0,0};
        int[] nums2=new int[]{2,4,6};
        int m=3,n=3;
        new MergeSortedArray().merge(nums1,m,nums2,n);
        for(int i=0;i<nums1.length;i++){
            System.out.print(nums1[i]+" ");
        }
    }
}
