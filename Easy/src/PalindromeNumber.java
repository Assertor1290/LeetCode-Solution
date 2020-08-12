/**
 * <p>
 * Determine whether an integer is a palindrome
 * Could you solve it without converting the integer to a string?
 * </p>
 */
public class PalindromeNumber {

    /**
     * Method 1 to determine if it is Palindrome
     * This method converts the Integer to String
     * Runtime:8ms Memory:39.8MB
     * @param x the integer to check if it is palindrome
     * @return true if palindrome  or false if not a palindrome
     */
    public boolean isPalindrome(int x){
        if(x<0)
            return false;

        int flag=0;
        String temp=Integer.toString(x);
        int[] pal=new int[temp.length()];
        for(int i=0;i<temp.length();i++){
            //Integers 0-9 have ASCII value from 48 to 57
            //'5' has the int value 53
            //if we write '5'-'0' it evaluates to 53-48, or the int 5
            pal[i]=temp.charAt(i)-'0';
        }
        //i starts from first index, j starts from last index
        for(int i=0,j=pal.length-1;i<pal.length/2;i++,j--){
            if(pal[i]!=pal[j]){
                flag=-1;
                break;
            }
        }
        if(flag == -1)
            return false;
        else
            return true;
    }
    /**
     * Method 2 to determine if it is Palindrome
     * It is slight improvement over Method 1. This method uses the String directly
     * Runtime:7ms Memory:38.6MB
     * @param x the integer to check if it is palindrome
     * @return true if palindrome  or false if not a palindrome
     */
    public boolean isPalindrome2(int x){
        if(x<0)
            return false;

        int flag=0;
        String temp=Integer.toString(x);
        //i starts from first index, j starts from last index
        for(int i=0,j=temp.length()-1;i<temp.length()/2;i++,j--){
            if(temp.charAt(i)!=temp.charAt(j)){
                flag=-1;
                break;
            }
        }
        if(flag == -1)
            return false;
        else
            return true;
    }
    /**
     * Method 3 to determine if it is Palindrome
     * Runtime: Memory
     * @param x the integer to check if it is palindrome
     * @return true if palindrome  or false if not a palindrome
     */
    public boolean isPalindrome3(int x){

    }
    public static void main(String[] args) {
        int a=123;
        System.out.println(new PalindromeNumber().isPalindrome(a));
        System.out.println(new PalindromeNumber().isPalindrome2(a));
        System.out.println(new PalindromeNumber().isPalindrome3(a));
    }
}
