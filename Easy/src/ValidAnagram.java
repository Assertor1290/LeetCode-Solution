import java.util.Arrays;
import java.util.HashMap;

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

    /**
     * For Follow Up question
     * Runtime:17ms, Memory:39.7MB
     * @param s first input string
     * @param t second input string
     * @return true if it is anagram, else false
     */
    public boolean isAnagram3(String s, String t){
        HashMap<Character,Integer> smap=new HashMap<>();
        int sl=s.length();
        int tl=t.length();
        if(sl!=tl){return false;}
        for(int i=0;i<sl;i++){
            smap.put(s.charAt(i),smap.getOrDefault(s.charAt(i),0)+1);
            smap.put(t.charAt(i),smap.getOrDefault(t.charAt(i),0)-1);
        }
        //keySet() method in Java is used to create a set out of the key
        // elements contained in the hash map. I
        for(char c:smap.keySet()){
            //The get() method of Map interface in Java is used to retrieve or
            //fetch the value mapped by a particular key mentioned in the parameter.
            if(smap.get(c)!=0){return false;}
        }

        return true;
    }

    public static void main(String[] args) {
        String s="anagram",t="nagaram";
        System.out.println(new ValidAnagram().isAnagram(s,t));
        System.out.println(new ValidAnagram().isAnagram2(s,t));
        System.out.println(new ValidAnagram().isAnagram3(s,t));
    }
}
