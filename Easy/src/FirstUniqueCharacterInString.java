import java.util.HashMap;

/**
 * <p>
 *     Given a string, find the first non-repeating character in it
 *     and return its index. If it doesn't exist, return -1.
 * </p>
 */
public class FirstUniqueCharacterInString {

    /**
     * Runtime:22ms, Memory:40MB
     * Use HashMap to store characters and their count
     * @param s input string
     * @return index of first unique character
     */
    public int firstUniqueCharacter3(String s) {
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            //The getOrDefault(key, defaultValue) method of Properties class is used to get
            //the value mapped to this key, passed as the parameter, in this Properties object.
            //This method will fetch the corresponding value to this key, if present, and return it.
            //If there is no such mapping, then it returns the defaultValue.

            //So for first time since charcter is not there it will return 0 + 1
            //next time it will be previous value +1

            //also, HashMap overwrites previous key if it exists
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        // find the index
        for (int i = 0; i < n; i++) {
            if (count.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }

    /**
     * Runtime:20ms Memory:40.2MB
     * @param s input string
     * @return index of first unique character
     */
    public int firstUniqueCharacter2(String s) {
        char[] a=s.toCharArray();
        for (char c : a)
            if(s.indexOf(c) == s.lastIndexOf(c))
                return s.indexOf(c);
        return -1;
    }

    /**
     * Runtime:5ms, Memory:40.1MB
     * @param s input string
     * @return index of first unique character
     */
    public int firstUniqueCharacter1(String s) {
        int[] freq = new int[26];
        char a[]=s.toCharArray();
        for(char c : a ){
            //eg if character is a, then freq[97-97]+=1 i.e freq[0]+=1;
            //if character is c, then freq[99-97]+=1 i.e freq[2]+=1;
            freq[c-'a']++;
        }
        for(int i = 0; i<s.length(); i++) {
            if(freq[s.charAt(i)-'a']==1) return i;
        }
        return -1;
    }

    /**
     * Runtime:1ms, Memory:40.4MB
     * @param s input string
     * @return index of first unique character
     */
    public int firstUniqueCharacter(String s){
        int index =-1;
        //check for each character in the String
        for(int i='a';i<='z';i++){
            //tmpIndex has first occurrence of character
            int tmpIndex = s.indexOf(i);
            //if character exists && if first occurrence == last occurrence of character i.e it is unique
            //character && (index==-1 for first time || if the unique character's index is less than previous
            //unique character
            if(tmpIndex>=0 && tmpIndex==s.lastIndexOf(i) && (index== -1 || index>tmpIndex)) {
                index=tmpIndex;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        String s="loveleetcode";
        System.out.println(new FirstUniqueCharacterInString().firstUniqueCharacter(s));
        System.out.println(new FirstUniqueCharacterInString().firstUniqueCharacter1(s));
        System.out.println(new FirstUniqueCharacterInString().firstUniqueCharacter2(s));
        System.out.println(new FirstUniqueCharacterInString().firstUniqueCharacter3(s));
    }
}
