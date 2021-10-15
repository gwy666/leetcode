package first200;

import org.junit.Test;

import java.util.Stack;

public class Lc150 {
    public int evalRPN(String[] tokens) {
        Stack<String> stack=new Stack<>();
        for(String s:tokens){
            if(isDigit(s)){
                stack.push(s);
            }
            else{
                int n=Integer.parseInt(stack.pop());
                int m=Integer.parseInt(stack.pop());
                if(s.equals("+")){
                    stack.push(String.valueOf(m+n));
                }
                if(s.equals("-")){
                    stack.push(String.valueOf(m-n));
                }
                if(s.equals("*")){
                    stack.push(String.valueOf(m*n));
                }
                if(s.equals("/")){
                    stack.push(String.valueOf(m/n));
                }
            }
        }
        System.out.println(stack.size());
        return Integer.parseInt(stack.pop());
    }
    public boolean isDigit(String s){
        if(s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")){
            return false;
        }
        return true;
    }
    @Test
    public void test(){
        String tokens[] = new String[]{"2","1","+","3","*"};
        System.out.println(evalRPN(tokens));
    }
}
