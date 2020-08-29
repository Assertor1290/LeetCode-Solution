/**
 * <p>
 *      Given two arrays, write a function to compute their intersection.
 *      Note:
 *      Each element in the result must be unique.
 *      The result can be in any order.
 * </p>
 */
public class IntersectionOfTwoArraysOne {
    /**
     * Runtime: 6ms, Memory:39.6MB
     * nums1.length = n, nums2.length = m
     * O (n * m * min(n, m)) time, O(min(n, m)) space
     * The naive approach would be to iterate along the first array nums1 and
     * to check for each value if this value in nums2 or not. If yes - add the value to output.
     * @param nums1 first input array
     * @param nums2 second input array
     * @return intersected array
     */
    public int[] intersection(int[] nums1, int[] nums2) {

        // since interested array cant be longer than smallest array, hence
        //initializing new array with size of smaller array
        int[] intersect = new int[Math.min(nums1.length, nums2.length)];
        int index = 0;
        for (int i = 0; i < nums1.length; i++)
        {
            for (int j = 0; j < nums2.length; j++)
            {
                if (nums1[i] == nums2[j])
                {
                    boolean isUnique = true;
                    for (int k = 0; k < index; k++)
                    {
                        if (nums1[i] == intersect[k])
                        {
                            isUnique = false;
                        }
                    }
                    if (isUnique)
                    {
                        intersect[index++] = nums1[i];
                    }
                }
            }
        }
        int[] result = new int[index];
        for (; index-1 >= 0; index--)
        {
            result[index-1] = intersect[index-1];
        }
        return result;
    }
    public static void main(String[] args) {

    }
}
