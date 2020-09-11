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
     * @param nums1 first input array
     * @param nums2 second input array
     * @return median
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
    /**
     * Recursive method
     * https://medium.com/@hazemu/finding-the-median-of-2-sorted-arrays-in-logarithmic-time-1d3f2ecbeb46
     * Runtime:2ms, Memory:40.2MB
     * @param nums1 first input array
     * @param nums2 second input array
     * @return median
     */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2){
        int m = nums1.length;
        int n = nums2.length;
        // to ensure m<=n // Make sure we always search the shorter array.
        if (m > n) {
            int[] temp = nums1; nums1 = nums2; nums2 = temp;
            int tmp = m; m = n; n = tmp;
        }
        // Since A is guaranteed to be either shorter or of
        // the same length as B, we know it can contribute
        // 0 or all of its values to the left half of A ∪ B. => imin=0
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;

        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;

            if (i < iMax && nums2[j-1] > nums1[i]){
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && nums1[i-1] > nums2[j]) {
                iMax = i - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
    public static void main(String[] args) {
        int[] nums1=new int[]{1,2};
        int[] nums2=new int[]{3,4};
        System.out.println(new MedianTwoSortedArrays().findMedianSortedArrays(nums1,nums2));
    }
}
