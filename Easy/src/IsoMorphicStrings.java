import java.util.HashMap;

/**
 * <p>
 *     Given two strings s and t, determine if they are isomorphic.
 *     Two strings are isomorphic if the characters in s can be replaced to get t.
 *
 *      All occurrences of a character must be replaced with another character
 *      while preserving the order of characters. No two characters may map
 *      to the same character but a character may map to itself.
 * </p>
 */
public class IsoMorphicStrings {
    /**
     * Runtime: 4ms, Memory:39MB
     * @param s first string
     * @param t second string
     * @return true if isomorphic, else false
     */
    public boolean isIsomorphic(String s, String t) {
        // If the lengths of the string are not equal, then they can not be isomorphic
        if (s.length() != t.length()) {
            return false;
        }
        // Set hashMap so we can assgin keys and values to the strings.
        HashMap<Character, Character> map = new HashMap<>();

        //Can use s.toCharArray but it is slower
        //char[] arrayS=s.toCharArray();
        //char[] arrayT=t.toCharArray();

        // Create two char arrays for the strings.
        char[] arrayS = new char[s.length()];
        char[] arrayT = new char[t.length()];

        for (int i = 0; i < s.length(); i++) {
            arrayS[i] = s.charAt(i);
        }

        for (int j = 0; j < t.length(); j++) {
            arrayT[j] = t.charAt(j);
        }

        // Iterate through the length of one of the arrays, (they are the same length)!
        for (int k = 0; k < arrayS.length; k++) {
            char s1 = arrayS[k];
            char t1 = arrayT[k];

            // If the map does not have the key and value, create them. eg
            // s = aba
            // t = cda
            if (!map.containsKey(s1) && !map.containsValue(t1)) {
                map.put(s1, t1);
            }
            // If the map does not contains a key but contains the value,
            // same value 'c' has different key
            // s= ab
            // t= cc
            // or the value of the key does not match with the key (after some iterations) return false.
            // same key 'a' has different value
            // s = aba
            // t = cde
            if((!map.containsKey(s1) && map.containsValue(t1) || !map.get(s1).equals(t1)))
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Runtime:2ms Memory:38.9MB
     * @param s first string
     * @param t second string
     * @return true if isomorphic, else false
     */
    public boolean isIsomorphic2(String s, String t) {
        int[] x = new int[256];
        int[] y = new int[256];
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        for(int i = 0;i<s1.length;i++){
            if(x[s1[i]] != y[t1[i]])
                return false;
            x[s1[i]] = i+1;
            y[t1[i]] = i+1;
        }
        return true;
    }

    public static void main (String[]args){
        String s = "egg", t = "add";
        System.out.println(new IsoMorphicStrings().isIsomorphic(s, t));
        System.out.println(new IsoMorphicStrings().isIsomorphic2(s, t));
    }
}
