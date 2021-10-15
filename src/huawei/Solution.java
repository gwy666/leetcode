package huawei;

import org.junit.Test;

import java.util.Stack;

//官万瑶
public class Solution {
    public boolean isMathched(String s){
        int n=s.length();
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(c==')'){
                if(stack.isEmpty()||stack.peek()!='('){
                    return false;
                }
                stack.pop();
            }
            else if(c==']'){
                if(stack.isEmpty()||stack.peek()!='['){
                    return false;
                }
                stack.pop();
            }
            else if(c=='}'){
                if(stack.isEmpty()||stack.peek()!='{'){
                    return false;
                }
                stack.pop();
            }
            else stack.push(c);
        }
        return stack.isEmpty();
    }

    @Test
    public void test(){
        String s="()()[]";
        System.out.println(isMathched(s));
    }
}
