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
     * Approach: Revert half number: Idea is to revert the number itself, and then compare the number
     * with original number, if they are the same, then the number is a palindrome.
     * However, if the reversed number is larger than int.MAX, we will hit integer overflow problem.
     * To avoid the overflow issue of the reverted number we revert only half of the number
     * This method does not use Integer to String conversion
     * Runtime: Memory
     * @param x the integer to check if it is palindrome
     * @return true if palindrome  or false if not a palindrome
     */
    public boolean isPalindrome3(int x){
        /*
         Also if the last digit of the number is 0, in order to be a palindrome,
         the first digit of the number also needs to be 0, which is not possible
         Only 0 satisfy this property.
         */
        if(x<0 || (x%10==0 && x!=0))
            return false;

        int rev=0;
        //while original number is greater than reversed number
        while(x>rev){
            rev=rev*10+x%10;
            x=x/10;
        }
        return x==rev || x==rev/10;
    }
    public static void main(String[] args) {
        int a=123;
        System.out.println(new PalindromeNumber().isPalindrome(a));
        System.out.println(new PalindromeNumber().isPalindrome2(a));
        System.out.println(new PalindromeNumber().isPalindrome3(a));
    }
}
