/**
 * <p>
 * You are a product manager and currently leading a team to develop a new product.
 * Unfortunately, the latest version of your product fails the quality check.
 * Since each version is developed based on the previous version, all the versions after a
 * bad version are also bad.
 *
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one,
 * which causes all the following ones to be bad.
 *
 * You are given an API bool isBadVersion(version) which will return whether version is bad.
 * Implement a function to find the first bad version. You should minimize the number of calls to the API.
 * </p>
 */
public class FirstBadVersion {
    /**
     * Linear Time Complexity
     * TLE
     * Time:O(n) Space:O(1)
     * @param n input
     * @return value of n when first bad version occurs
     */
    public int firstBadVersion(int n) {
        for (int i = 1; i < n; i++) {
            if (isBadVersion(i)) {
                return i;
            }
        }
        return n;
    }

    /**
     * Binary Search
     * Time:O(log n) Space:O(1)
     * @param n input
     * @return value of n when first bad version occurs
     */
    public int firstBadVersion2(int n) {
        int left=1;
        int right=n;
        while(left<right){
            // mid = (start+end)) / 2;
            // This can caused OVERFLOW !
            // when start and end are all about INT_MAX , then (start+end) will cause overflow !
            // To avoid the problem we can use
            // mid =  start+(end-start)/2;
            int mid=left+(right-left)/2;
            if(isBadVersion(mid)){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
    public static void main(String[] args) {
        //No code here as isBadVersion is an API, and
        //no information about the function is provided
    }
}
