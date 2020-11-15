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

    /**
     * More optimized method that returns longest common prefix
     * Runtime- 0ms, Memory-37.4MB
     * Solution is Linear O(n)
     * @param str the array of strings
     * @return prefix the longest common prefix
     */
    public String longestCommonPrefix2(String[] str){
        String prefix="";
        if(str.length==0){
            return prefix;
        }
        prefix=str[0];
        for(int i=1;i<str.length;i++){
            /**
             * indexOf returns the index Of prefix in str[i].
             * str[i] contains only one word. So, if prefix is in str[i], it will return index 0, else -1
             * and if the prefix is not found in the beginning of the element from the list,
             * then pop the last character from the prefix.
             * eg: Flower, flow
             * flow.indexOf(flower) returns -1. So decrease flower by 1
             * flow.indexOf(flowe) returns -1. So decrease flowe by 1.
             * flow.indexOf(flow) returns 0. While loop ends. Increment i.
             * flight.indexOf(flow) and so on....
             */
            while(str[i].indexOf(prefix)!=0){
                prefix=prefix.substring(0,prefix.length()-1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    /**
     * Method works on Vertical spanning
     * Better in best case scenario than previous method
     * Runtime 0ms Memory 37.3MB
     * @param str array of String type
     * @return longest common prefix
     */
    public String longestCommonPrefix3(String[] str){
        if(str.length==0){
            return "";
        }
        //lopp through distance of first word
        for(int i=0;i<str[0].length();i++){
            //store first character of first word
            char c=str[0].charAt(i);
            //loop through remaining strings column by column
            for(int j=1;j<str.length;j++){

                //if length of other words is less than the first word
                //or the character becomes unequal, return
                if(i==str[j].length() || str[j].charAt(i)!=c){
                    return str[0].substring(0,i);
                }
            }
        }
        //this will execute if length of first word is less than others
        return str[0];
    }

    /**
     * Divide and Conquer
     * In the worst case we have n equal strings with length m
     * Time:  O(s), s=no of all characters
     * Space: O(m.log n)
     * @param str array of String type
     * @return longest common prefix
     */
    public String longestCommonPrefix4(String[] str){
        if(str==null || str.length==0) return " ";
            return longestCommonPrefix(str,0, str.length-1);
    }
    public String longestCommonPrefix(String[] strs, int l, int r){
        if(l==r)
            return strs[l];
        else {
            int mid = (l+r)/2;
            String lcpLeft=longestCommonPrefix(strs,l,mid);
            String lcpRight=longestCommonPrefix(strs,mid+1,r);
            return commonPrefix(lcpLeft,lcpRight);
        }
    }
    String commonPrefix(String left, String right){
        int min=Math.min(left.length(),right.length());
        for(int i=0;i<min;i++){
            if(left.charAt(i)!=right.charAt(i))
                return left.substring(0,i);
        }
        return left.substring(0,min);
    }

    public static void main(String[] args) {
        String[] test={"flower","flow","flight"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(test));
        System.out.println(new LongestCommonPrefix().longestCommonPrefix2(test));
        System.out.println(new LongestCommonPrefix().longestCommonPrefix3(test));
        System.out.println(new LongestCommonPrefix().longestCommonPrefix4(test));
    }
}
