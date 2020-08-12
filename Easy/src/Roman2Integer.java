import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *     Given a roman numeral, convert it to an integer
 * </p>
 */
public class Roman2Integer {
    /**
     * Method 1 to convert Roman Numeral to integer
     * Runtime:4ms Memory:39.7MB
     * @param s The String containing the Roman numeral
     * @return the integer corresponding to the Roman numeral
     */
    public int roman2Integer(String s){
        int sum=0;
        //loop through the length of that string
        for(int i=0;i<s.length();i++){
            /**
             * Observe the pattern in following
             * IV = 4 = 5-1 = V-I = charAt(i+1) - charAt(i)
             * IX = 9 = 10-1 = X-I = charAt(i+1) - charAt(i)
             * CD = 400 = 500-100 = D-C= charAt(i+1) - charAt(i)
             * There are six instances where subtraction is used:
             *          I can be placed before V (5) and X (10) to make 4 and 9.
             *          X can be placed before L (50) and C (100) to make 40 and 90.
             *          C can be placed before D (500) and M (1000) to make 400 and 900.
             * So whenever the Roman Numeral at current position(i) is less than Roman Numeral at successive position(i+1),
             * the value of current Roman Numeral is subtracted from sum else
             * its value is added to the sum
             */
            if(i+1 < s.length() && getValue(s.charAt(i)) < getValue(s.charAt(i+1)))
                sum=sum-getValue(s.charAt(i));
            else
                sum=sum+getValue(s.charAt(i));
        }
        return sum;
    }

    /**
     * Method to return the Integer value of pre defined Roman Numerals
     * @param c The character
     * @return the integral value of that roman numeral
     */
    public int getValue(char c){
        int sum=0;
        switch (c){
            case 'I':return 1;
            case 'V':return 5;
            case 'X':return 10;
            case 'L':return 50;
            case 'C':return 100;
            case 'D':return 500;
            case 'M':return 1000;
        }
        return 0;
    }

    /**
     * Method 2 to convert Roman Numeral to integer
     * Runtime:5ms Memory:39.9MB
     * @param s The String containing the Roman numeral
     * @return the integer corresponding to the Roman numeral
     */
    public int roman2Integer2(String s){
        int sum=0;
        /**
         * Instead of defining a getValue function as in method 1, we
         * store those key value pairs in Map.
         */
        Map<Character,Integer> map=new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        for(int i=0;i<s.length();i++){
            if(i+1<s.length() && map.get(s.charAt(i))<map.get(s.charAt(i+1)))
                sum=sum-map.get(s.charAt(i));
            else
                sum=sum+map.get(s.charAt(i));
        }
        return sum;
    }

    /**
     * Method 3 to convert Roman Numeral to integer
     * Runtime:3ms Memory:39.8MB
     * @param s The String containing the Roman numeral
     * @return the integer corresponding to the Roman numeral
     */
    public int roman2Integer3(String s){
        char[] c=s.toCharArray();
        int sum=0;
        for(int i=0;i<s.length();i++){
            switch (c[i]){
                case 'I':
                    if(i+1<s.length() && (c[i+1]=='V' || c[i+1]=='X'))
                        sum-=1;
                    else
                        sum+=1;break;
                case 'V':
                    sum=sum+5;break;
                case 'X':
                    if(i+1<c.length && (c[i+1]=='L' || c[i+1]=='C'))
                        sum=sum-10;
                    else
                        sum=sum+10;
                    break;
                case 'L':
                    sum=sum+50;break;
                case 'C':
                    if(i+1<c.length && (c[i+1]=='D' || c[i+1]=='M'))
                        sum=sum-100;
                    else
                        sum=sum+100;
                    break;
                case 'D':
                    sum=sum+500;break;
                case 'M':
                    sum=sum+1000;break;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        String test="LVIII";
        System.out.println(new Roman2Integer().roman2Integer(test));
        System.out.println(new Roman2Integer().roman2Integer2(test));
        System.out.println(new Roman2Integer().roman2Integer3(test));
    }
}
