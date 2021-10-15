package first200;

import org.junit.Test;

public class Lc32 {

    public int longestValidParentheses(String s) {
        int n=s.length();
        int res=0;
        int dp[]=new int[n];
        dp[0]=0;
        int index=0;
        for(int i=1;i<n;i++){
            char c=s.charAt(i);
            if(c=='(')dp[i]=0;
            else{
                if(s.charAt(i-1)=='('){
                    dp[i]=2;
                    if(i-2>=0)dp[i]+=dp[i-2];
                }
                else{
                    if(dp[i-1]==0)dp[i]=0;
                    else{
                        if(i-1-dp[i-1]>=0)dp[i]=s.charAt(i-1-dp[i-1])=='('?dp[i-1]+2:0;
                        if(i-1-dp[i-1]-1>=0&&s.charAt(i-1-dp[i-1])=='(')dp[i]+=dp[i-1-dp[i-1]-1];
                    }
                }
            }
            if(dp[i]>res){
                res=dp[i];
                index=i;
            }
        }
        for(int i:dp){
            System.out.print(i+" ");
        }
        System.out.println();
        return res;
    }
    @Test
    public void test(){
        String s="))())()()())))";
        System.out.println(longestValidParentheses(s));
    }
}
