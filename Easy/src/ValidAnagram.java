import java.util.Arrays;

/**
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */
public class ValidAnagram {
    /**
     * To examine if t is a rearrangement of s, we can count occurrences of each letter in the
     * two strings and compare them. Since both s and t contain only letters from a−z,
     * a simple counter table of size 26 is suffice.
     * Do we need two counter tables for comparison? Actually no, because we could
     * increment the counter for each letter in s and decrement the counter for each letter in t,
     * then check if the counter reaches back to zero.
     * Runtime:3ms, Memory:39.3MB
     * @param s first input string
     * @param t second input string
     * @return true if it is anagram, else false
     */
    public boolean isAnagram(String s,String t){
        if(s.length()!=t.length()){
            return false;
        }
        int[] count=new int[26];
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
            count[t.charAt(i)-'a']--;
        }

        for(int i=0;i<26;i++){
            if(count[i]!=0){
                return false;
            }
        }
        return true;
    }
    /**
     * An anagram is produced by rearranging the letters of s into t.
     * Therefore, if t is an anagram of s, sorting both strings will
     * result in two identical strings. Furthermore, if s and t have different lengths,
     * t must not be an anagram of s and we can return early.
     * Time Complexity:O(nlogn) Space:O(1)
     * Runtime:2ms, Memory:39.1MB
     * @param s first input string
     * @param t second input string
     * @return true if it is anagram, else false
     */
    public boolean isAnagram2(String s, String t) {
        if(s.length()!=t.length())
            return false;

        char[] a=s.toCharArray();
        char[] b=t.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a,b);
    }

    public static void main(String[] args) {
        String s="anagram",t="nagaram";
        System.out.println(new ValidAnagram().isAnagram(s,t));
    }
}
