package hot100;

import java.util.Stack;

public class Lc20 {

    public boolean isValid(String s) {

        Stack<Character> stack=new Stack<>();
        char ch[]=s.toCharArray();
        for (char c : ch) {
            if(c!=')'&&c!=']'&&c!='}'){
                stack.push(c);
            }
            else{
                if(c==')'){
                    if(stack.isEmpty()||stack.peek()!='(')return false;
                    else stack.pop();
                }
                if(c==']'){
                    if(stack.isEmpty()||stack.peek()!='[')return false;
                    else stack.pop();
                }
                if(c=='}'){
                    if(stack.isEmpty()||stack.peek()!='{')return false;
                    else stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}
