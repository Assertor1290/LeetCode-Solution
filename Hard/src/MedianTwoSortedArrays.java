/**
 * <p>
 * Given two sorted arrays nums1 and nums2 of size m and n respectively,
 * return the median of the two sorted arrays.
 * Follow up: The overall run time complexity should be O(log (m+n)).
 * </p>
 */
public class MedianTwoSortedArrays {
    /**
     * Iterative method
     * Runtime:2ms, Memory:40.2MB
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        //size of merged array is m+n
        int p=m+n;
        //to find median is of single term or two terms
        boolean isOdd = (p & 1) == 1;
        int[] arr=new int[p];
        //i is counter for new array, j and k are counter for given two arrays
        int i=0,j=0,k=0;
        while(j<m && k<n){
            //if value of array1 is less than array2, assign the value to new array
            //and increment counter of array1 by 1
            if(nums1[j]<=nums2[k]){
                arr[i]=nums1[j];
                j++;
            }
            //if value of array2 is less than array1, assign the value to new array
            //and increment counter of array2 by 1
            else{
                arr[i]=nums2[k];
                k++;
            }
            //increment counter of new array
            i++;
        }
        //add remaining elements of array 1 to new array
        if(j<m){
            for(;j<m;j++){
                arr[i]=nums1[j];
                i++;
            }
        }
        //add remaining elements of array 2 to new array
        if(k<n){
            for(;k<n;k++){
                arr[i]=nums2[k];
                i++;
            }
        }
        if(isOdd)
            return arr[p/2];

        return (arr[(p/2)-1]+arr[p/2])/2.0;
    }
    public static void main(String[] args) {
        int[] nums1=new int[]{1,2};
        int[] nums2=new int[]{3,4};
        System.out.println(new MedianTwoSortedArrays().findMedianSortedArrays(nums1,nums2));
    }
}
