/**
 * <p>
 * Given a non-negative integer x, compute and return the square root of x.
 * Since the return type is an integer, the decimal digits are truncated,
 * and only the integer part of the result is returned.
 * </p>
 */
public class Sqrt {
    /**
     * Binary search
     * TC: O(logn)
     * @param x input
     * @return square root
     */
    public int sqrt(int x){
        if(x==0){
            return 0;
        }
        int left=1;
        //start with a range between 1 to x/2
        //(square root of any number can not be greater than half of the number)
        int right=x/2;
        while(left<=right){
            int mid = left + (right-left)/2;
            //if n * n <= x < (n + 1) * (n + 1) then we return n
            if(mid <= x/mid && mid+1 > x/(mid+1)){
                return mid;
            }
            // use division instead of multiplication to avoid overflow
            if(mid > x/mid){
                right =mid-1;
            }
            else {
                left=mid+1;
            }
        }
        return left;
    }
    public static void main(String[] args) {
        System.out.println(new Sqrt().sqrt(9));
        System.out.println(new Sqrt().sqrt(10));
    }
}
