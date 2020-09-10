/**
 * <p>
 *     
 * </p>
 */
public class MedianTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int p=m+n;
        boolean isOdd = (p & 1) == 1;
        int[] arr=new int[p];
        int i=0,j=0,k=0;
        while(j<m && k<n){
            if(nums1[j]<=nums2[k]){
                arr[i]=nums1[j];
                j++;
            }
            else{
                arr[i]=nums2[k];
                k++;
            }
            i++;
        }
        if(j<m){
            for(;j<m;j++){
                arr[i]=nums1[j];
                i++;
            }
        }
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
