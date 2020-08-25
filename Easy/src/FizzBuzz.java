import java.util.ArrayList;
import java.util.List;

/**
 * <p>Write a program that outputs the string representation of numbers from 1 to n.
 * But for multiples of three it should output “Fizz” instead of the number and
 * for the multiples of five output “Buzz”. For numbers which are multiples of both
 * three and five output “FizzBuzz”</p>
 */
public class FizzBuzz {
    /**
     * Runtime:1ms, Memory:45.7MB
     * @param n input integer
     * @return list of String
     */
    public List<String> fizzBuzz(int n){
        List<String> list=new ArrayList<>();
        for(int i=1,fizz=0,buzz=0;i<=n;i++){
            fizz++;
            buzz++;
            //if multiple of both 3 and 5
            if(fizz==3 && buzz==5){
                list.add("FizzBuzz");
                fizz=0;
                buzz=0;
            }
            else if (fizz==3){
                list.add("Fizz");
                fizz=0;
            }
            else if(buzz==5){
                list.add("Buzz");
                buzz=0;
            }
            else {
                list.add(String.valueOf(i));
            }
        }
        return list;
    }
    public static void main(String[] args) {
        System.out.println(new FizzBuzz().fizzBuzz(15));
    }
}
