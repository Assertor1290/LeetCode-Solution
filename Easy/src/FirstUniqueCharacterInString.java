/**
 * <p>
 *     Given a string, find the first non-repeating character in it
 *     and return its index. If it doesn't exist, return -1.
 * </p>
 */
public class FirstUniqueCharacterInString {

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
    }
}
