/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
 * return the length of last word (last word means the last appearing word if we loop
 * from left to right) in the string.
 *
 * If the last word does not exist, return 0.
 */
public class LengthOfLastWord {
    /**
     * Runtime:0ms  Memory:37.7MB
     * @param s input string
     * @return length of last word
     */
    public int lengthOfLastWord(String s){
        int count =0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)==' '){
                //if it is not a trailing space, return length
                if(count!=0) return count;
            }
            else {
                count++;
            }
        }
        return count;
    }

    /**
     * Using pre built functions
     * @param s input string
     * @return length of last word
     */
    public int lengthOfLastWord2(String s){
        s = s.trim();
        int lastIndex = s.lastIndexOf(' ') + 1;
        return s.length() - lastIndex;
    }

    public static void main(String[] args) {
        String s="Hello World";
        System.out.println(new LengthOfLastWord().lengthOfLastWord(s));
        System.out.println(new LengthOfLastWord().lengthOfLastWord2(s));
    }
}
