/**
 * <p>
 *      Write an algorithm to determine if a number n is "happy".
 *      A happy number is a number defined by the following process:
 *      Starting with any positive integer, replace the number by the sum of the squares of its digits,
 *      and repeat the process until the number equals 1 (where it will stay),
 *      or it loops endlessly in a cycle which does not include 1.
 *      Those numbers for which this process ends in 1 are happy numbers.
 *
 *      Return True if n is a happy number, and False if not.
 * </p>
 */
public class HappyNumber {
    public boolean isHappy(int n){
        while (true){
            int sum=0;
            while (n!=0){
                //here, we have to extract the digits from the given number starting from the last one
                int lastDigit=n%10;
                //add that digit to the sum, by squaring it
                sum+=lastDigit*lastDigit;
                n/=10;
            }
            //if it is a single digit number, check if it 1 or 7
            if(sum/10==0){
                //7 will also lead to 1
                //7^2 = 49 = 4^2+9^2 = 97 = 9^2+7^2 = 130 = 1^2+3^2+0^2 = 10 = 1^2+0^2 = 1
                if(sum==1||sum==7){
                    return true;
                }
                // else you want to terminate the loop as it isn't a happy number
                else
                    return false;
            }
            n=sum;
        }
    }
    public static void main(String[] args) {
        int n=19;
        System.out.println(new HappyNumber().isHappy(n));
    }
}
