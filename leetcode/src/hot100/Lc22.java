package hot100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Lc22 {

    public List<String> generateParenthesis(int n) {
        backtrack(0,0,n,new StringBuffer());
        return res;
    }
    List<String >res=new ArrayList<>();
    public void backtrack(int left,int right,int n,StringBuffer sb){
        if(left<right||left>n||right>n){
            return ;
        }
        if(left==right&&left==n){
            res.add(new String(sb));
            return ;
        }
        sb.append('(');
        backtrack(left+1,right,n,sb);
        sb.deleteCharAt(sb.length()-1);
        sb.append(')');
        backtrack(left,right+1,n,sb);
        sb.deleteCharAt(sb.length()-1);
    }

    @Test
    public void test(){
        int n=3;
        System.out.println(generateParenthesis(n));
    }
}
