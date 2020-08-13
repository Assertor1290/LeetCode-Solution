/**
 * <p>Return the index of the first occurrence of needle in haystack,
 * or -1 if needle is not part of haystack.</p>
 */
public class ImplementstrStr {
    /**
     * This method is equivalent of pre built Java's indexOf method.
     * Runtime:0ms Memory:39.7MB
     * @param haystack The string in which we have to search
     * @param needle The string to search
     * @return index of occurence of needle in haystack
     */
    public int strStr(String haystack,String needle){
        int h=haystack.length();
        int n=needle.length();
        //larger string cant be present in smaller string
        if(h<n) return -1;
        //if needle is empty
        if(n==0) return 0;

        //iterate over through the haystack string and use substring
        //method to find if it is equal to needle
        for(int i=0;i<=h-n;i++){
            if(haystack.substring(i,i+n).equals(needle))
                return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        String haystack="aaaaa",needle="bba";
        System.out.println(new ImplementstrStr().strStr(haystack,needle));
    }
}
