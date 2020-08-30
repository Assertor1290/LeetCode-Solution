/**
 * <p>
 *     Write a function that reverses a string.
 *     The input string is given as an array of characters char[].
 *     Do not allocate extra space for another array, you must do this by
 *     modifying the input array in-place with O(1) extra memory.
 * </p>
 */
public class ReverseString {
    /**
     * Runtime:1ms, Memory:46.2MB
     * Time complexity : O(N) to swap N/2 element
     * Space complexity : O(1), it's a constant space solution.
     * Based on opposite two directional pointer approach
     * @param s input character array
     */
    public void reverseString(char[] s) {
        char temp;
        int j=s.length-1;
        for(int i=0;i<j;i++){
            temp=s[i];
            s[i]=s[j];
            s[j]=temp;
            j--;
        }
    }
    /**
     * Runtime:1ms, Memory:47.6MB
     * Time complexity : O(N) time to perform N/2 swaps.
     * Space complexity : O(N) to keep the recursion stack.
     * Based on opposite two directional pointer approach
     * @param s input character array
     */
    public void helper(char[] s, int left, int right) {
        if (left >= right) return;
        char tmp = s[left];
        s[left++] = s[right];
        s[right--] = tmp;
        helper(s, left, right);
    }

    public void reverseString2(char[] s) {
        helper(s, 0, s.length - 1);
    }
    public static void main(String[] args) {
        char[] s=new char[]{'h','e','l','l','o'};
        //new ReverseString().reverseString(s);
        //System.out.println(s);
        new ReverseString().reverseString2(s);
        System.out.println(s);
    }
}
