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

    public String addBinary2(String a,String b){
        //converting the string to char array
        char[] aArr = a.toCharArray();
        //converting the string to char array
        char[] bArr = b.toCharArray();
        //considering the max length +1 to hold carry forward value
        int cLength = Math.max(a.length(), b.length()) + 1;
        //defining the new array to hold the result
        char[] cArr = new char[cLength];
        char rem = '0';
        int aLen = aArr.length;
        int bLen = bArr.length;
        //iterating the result array length of times from right side
        for(int i=cArr.length-1; i>0; i--) {
            char aVal = '0';
            char bVal = '0';
            if(aLen > 0) {
                //reading the values of aArr from right side
                aVal = aArr[--aLen];
            }
            if(bLen > 0) {
                //reading the values of bArr from right side
                bVal = bArr[--bLen];
            }
            //adding the value of aArr, bArr and reminder
            char tmp = (char) (aVal + bVal + rem);
            rem = '0';
            // tmp variable holds the ascii value (e.g: 145 = '0' + '1' + '0')
            //ascii value of 0 is 48 so calculating the reminder value by doing the mod of '0'
            if(tmp % 48 >= 2) {
                rem = '1';
            }

            // tmp variable holds the ascii value (e.g: 145 = '0' + '1' + '0')
            //calculating the cVal by doing the mod 2 on tmp
            char cVal = (tmp%2 == 0) ? '0' : '1';
            cArr[i] = cVal;
            //assigning the reminder value to the left index of the current index
            cArr[i-1] = rem;
        }
        //0 th index always holds the reminder value
        //if the 0th index value is 1 then consider otherwise ignore it.
        int offset = (cArr[0] == '1') ? 0 : 1;
        return new String(cArr, offset, cArr.length-offset);
    }


    public static void main(String[] args) {
        String s1="1001",s2="1001";
        System.out.println(new AddBinary().addBinary(s1,s2));
        System.out.println(new AddBinary().addBinary2(s1,s2));
    }
}
