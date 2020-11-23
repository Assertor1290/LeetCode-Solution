/**
 * <p>Given two binary strings a and b, return their sum as a binary string.</p>
 */
public class AddBinary {

    /**
     * Runtime: 2ms, Memory: 37.5MB
     * @param s1 first input string
     * @param s2 second input string
     * @return sum of the binary strings
     */
    public String addBinary(String s1, String s2){
        int i=s1.length()-1;
        int j=s2.length()-1;
        int carry=0;
        StringBuilder sb=new StringBuilder();
        while(i>=0 || j>=0){
            int sum=0;
            //if String s1 still has characters left
            if(i>=0){
                sum+= s1.charAt(i)-'0';
                i--;
            }
            //if String s2 still has characters left
            if(j>=0){
                sum+= s2.charAt(j)-'0';
                j--;
            }
            sum+=carry;
            sb.append(sum%2);
            //possible sums are 0+0 =0, 0+1=0, 1+1=2
            carry=sum/2;
        }
        if(carry>0){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String s1="1001",s2="1001";
        System.out.println(new AddBinary().addBinary(s1,s2));
    }
}
