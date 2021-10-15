package hot100;

import org.junit.Test;

public class Lc5 {

    public String longestPalindrome(String s) {
        if(s.equals("")){
            return s;
        }
        int n=s.length();
        int start=0;
        int maxLen=1;
        boolean dp[][]=new boolean[n][n];
        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                if(i==j)dp[i][j]=true;
                else if(i+1==j) dp[i][j]=s.charAt(i)==s.charAt(j);
                else {
                    if(s.charAt(i)==s.charAt(j)){
                        dp[i][j]=dp[i+1][j-1];
                    }
                    else dp[i][j]=false;
                }
                if(dp[i][j]&&j-i+1>maxLen){
                    start=i;
                    maxLen=j-i+1;
                }
            }
        }
        return s.substring(start,start+maxLen);
    }

    @Test
    public void test(){
        String s="bb";
        System.out.println(longestPalindrome(s));
    }
}
