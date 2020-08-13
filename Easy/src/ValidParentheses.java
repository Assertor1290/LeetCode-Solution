import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * <p>
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 * </p>
 */
public class ValidParentheses {
    /**
     * Method to determine if the paranthesis are valid or not.
     * Runtime:1ms, Memory:37.5MB
     * @param s The string containing the parenthesis
     * @return true if expression is valid else false
     */
    public boolean isValid(String s){
        Map<Character,Character> map=new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            switch(s.charAt(i)){
                //if we encounter opening bracket, push it into the stack.
                case '(':
                case '{':
                case '[':
                    stack.push(s.charAt(i));break;
                //if we encounter closing bracket: -
                case ')':
                case '}':
                case ']':
                    //first check if stack is empty, it means it has no corresponding opening bracket
                    //hence expression is inValid
                    if(stack.isEmpty())return false;
                    //pop top charcter from stack.
                    char top=stack.pop();
                    //If the mapping for this bracket doesn't match the stack's top element, return false.
                    //i.e we encounter a different openeing bracket for given closing bracket.
                    if(map.get(s.charAt(i))!=top) return false;
            }
        }
        return stack.isEmpty()?true:false;
    }
    public static void main(String[] args) {
        String s="(((({}[][]()))))";
        System.out.println(new ValidParentheses().isValid(s));
    }
}
