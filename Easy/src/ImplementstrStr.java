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

    /**
     * Function to find index of pattern in text using KMP Algorithm
     * Time:O(m+n) Space:O(m)
     * @param haystack text string
     * @param needle pattern string
     * @return index of pattern/needle
     */
    public int strStrKMPSearch(String haystack, String needle){
        int M=needle.length();
        int N=haystack.length();
        //if length of text is less than pattern OR length of pattern is 0
        if(N<M || M==0){
            return 0;
        }
        //lps array
        int[] lps=new int[M];
        computeLPSArray(needle,M,lps);
        //Now use lps array to find index of pattern in text

        //index for text string(haystack)
        int i=0;
        //index for pattern(needle)
        int j=0;
        /**
         * Matching Traversal:
         * Time:O(n) Space:O(1)
         */
        while(i<N){
            if(needle.charAt(j)==haystack.charAt(i)){
                i++;
                j++;
            }
            if(j==M){
                //System.out.println("Found pattern at index "+(i-j));
                //to find successive matches
                //j=lps[j-1];

                //In question, finding only first occurrence of pattern
                return i-j;
            }
            //mismatch after j matches
            else if(i<N && needle.charAt(j)!=haystack.charAt(i)){
                //mismatch after j>0 matches
                if(j!=0)
                    //move to location ahead of prefix in pattern
                    j=lps[j-1];
                //mismatch at first character of pattern itself.
                //increment i only
                else i=i+1;
            }
        }
        return -1;
    }

    /**
     * Build Table
     * Time: O(m)
     * Space: O(m)
     * Function to compute longest proper prefix which is also a suffix.
     * @param pat pattern/needle
     * @param M length of pattern
     * @param lps lps arrat
     */
    public void computeLPSArray(String pat, int M, int[] lps){
        int i=0;
        int j=1;
        //First value is always zero
        lps[0]=0;
        //Loop while j is less than length of M
        while(j<M){
            //1. If Character at i is equal to Character at j, then
            if(pat.charAt(i)==pat.charAt(j)){
                //lps[j] = value at index i + 1;
                lps[j]=i+1;
                //increment both counters
                i++;
                j++;
            }
            //If Character at i is not equal to Character at j, then
            else{
                //2. if i is not at index 0, move i to index
                //which is equal to value in previous index.
                if(i!=0){
                    i=lps[i-1];
                }
                //3. if i at index 0, keep i there, put lps[j]=i/0;
                //and keep incrementing j repeatedly.
                else{
                    lps[j]=i;
                    j++;
                }
            }
        }
    }

    public static void main(String[] args) {
        String haystack="axabcabcaby",needle="abcaby";
        System.out.println(new ImplementstrStr().strStr(haystack,needle));
        System.out.println(new ImplementstrStr().strStrKMPSearch(haystack,needle));
    }
}
