/**
 * <p>
 *     Given a string, determine if it is a palindrome, considering only
 *     alphanumeric characters and ignoring cases.
 *     Note: For the purpose of this problem, we define empty string as valid palindrome.
 * </p>
 */
public class ValidPalindrome {
    /**
     * Runtime: 2ms
     * @param s input string
     * @return true if palindrome, else false
     */
    public boolean isPalindrome(String s){
        //If string is empty return true
        if(s.equals(" ")) return true;
        //convert o character array
        char[] array=s.toCharArray();
        int i=0,j=s.length()-1;
        while (i<j){
            if(!Character.isLetterOrDigit(array[i]))
                i++;
            else if(!Character.isLetterOrDigit(array[j]))
                j--;
            else if(Character.toLowerCase(array[i++])!=Character.toLowerCase(array[j--]))
                return false;
        }
        return true;
    }

    /**
     * Runtime: 1ms
     * @param s input string
     * @return true if palindrome, else false
     */
    public boolean isPalindrome2(String s){
        if(s.equals(" ")) return true;
        int i=0;
        int j=s.length()-1;

        while(i < j)
        {
            if(!isAlphanumeric(s.charAt(i)))
            {
                i++;
                continue;
            }

            if(!isAlphanumeric(s.charAt(j)))
            {
                j--;
                continue;
            }

            if(toLowerCase(s.charAt(i)) != toLowerCase(s.charAt(j)))
            {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean isAlphanumeric(char c)
    {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }

    private char toLowerCase(char c)
    {
        if(c >= 'A' && c <= 'Z')
        {
            //lowercase is 32 + uppercase
            return (char) (c + 32);
        }
        return c;
    }

    public static void main(String[] args) {
        String s="A man, a plan, a canal: Panama";
        System.out.println(new ValidPalindrome().isPalindrome(s));
        System.out.println(new ValidPalindrome().isPalindrome2(s));
    }
}

