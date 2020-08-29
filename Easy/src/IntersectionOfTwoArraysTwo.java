import java.util.Arrays;

/**
 * <p>
 *     Given two arrays, write a function to compute their intersection.
 *     Note:
 *     Each element in the result should appear as many times as it shows in both arrays.
 *     The result can be in any order.
 * </p>
 */
public class IntersectionOfTwoArraysTwo {
    /**
     * Runtime:2ms, Memory:39.6MB
     * @param nums1 first input array
     * @param nums2 second input array
     * @return intersected array
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                ++i;
            } else if (nums1[i] > nums2[j]) {
                ++j;
            } else {
                nums1[k++] = nums1[i++];
                ++j;
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }
    public static void main(String[] args) {
        int[] nums1=new int[]{4,9,5};
        int[] nums2=new int[]{9,4,9,8,4};
        System.out.println(Arrays.toString(new IntersectionOfTwoArraysTwo().intersect(nums1, nums2)));
    }
}
