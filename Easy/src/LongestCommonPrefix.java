/**
 * <p> Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".</p>
 */
public class LongestCommonPrefix {

    /**
     * Method returns the longest common prefix from array of Strings
     * Runtime:1 ms, Memory:37.1 MB
     * Solution: O(N x M) where N is the length of the given array and M is the max_length of a string
     * @param str An array of Strings
     * @return The longest common prefix
     */
    public String longestCommonPrefix(String[] str) {
        /**
         * result contains the final prefix
         */
        String result="";
        /**
         * if String array is empty return " "
         */
        if(str.length==0){
            return result;
        }
        /**
         * Let first element of String array be longest common prefix
         */
        result=str[0];

        /**
         * Loop through the remaining Strings in the array
         */
        for(int i=1;i<str.length;i++){
            /**
             * next contains successive strings
             */
            String next=str[i];

            /**
             * loop through the length of first string
             */
            for(int j=0;j<result.length();j++){
                /**
                 * When length of result is greater than next OR
                 * the character of result is not equal to character of next
                 * store the prefix upto that length in result and break from the loop
                 */
                if(j>=next.length() || result.charAt(j)!=next.charAt(j)){
                    result=result.substring(0,j);
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] test={"flower","flow","flight"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(test));
    }
}
