/**
 * <p>
 * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * </p>
 */
public class CountAndSay {
    /**
     * Method to return next number in sequence
     * Runtime:0ms, Memory:36.6MB
     * @param n the term whose sequence we have to return
     * @return the sequence
     */
    public String countAndSay(int n){
        //base case
        if(n==1)
            return "1";

        String s="1";
        //build numbers from 2 to n
        for(int i=2;i<=n;i++){
            s=nextNumber(s);
        }
        return s;
    }

    /**
     * Helper method
     * @param s the previous string/sequence
     * @return the next string/sequence
     */
    public String nextNumber(String s){
        StringBuilder sb=new StringBuilder();
        //take in previous number and run across it
        for(int i=0;i<s.length();i++){
            //initialize frequency of number
            int count =1;
            //while we don't reach the end and are still on the same number
            while((i+1)<s.length() && s.charAt(i)==s.charAt(i+1)){
                //increment frequency
                count++;
                //increment pointer
                i++;
            }
            //append the count and then the number
            sb.append(count).append(s.charAt(i));
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        int n=4;
        System.out.println(new CountAndSay().countAndSay(n));
    }
}
