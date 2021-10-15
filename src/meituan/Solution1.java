package meituan;

import org.junit.Test;


//求两个字符串的最长公共子串
public class Solution1 {
    
    public String LCS (String s1, String s2) {
        int m=s1.length();
        int n=s2.length();
        int maxLen=0;
        int dp[][]=new int[m+1][n+1];
        StringBuffer sb=new StringBuffer();
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        int i=m;
        int j=n;
        while(i>=1&&j>=1){
            if(dp[i-1][j]>dp[i][j-1]){
                i--;
            }
            else if(dp[i-1][j]<dp[i][j-1]){
                j--;
            }
            else {
                if(dp[i-1][j-1]==dp[i][j]-1){
                    sb.append(s1.charAt(i-1));
                }
                i--;
                j--;
            }
        }
        return sb.reverse().toString();
    }

    @Test
    public void test(){
        String s1="1A2C3D4B5c6";
        String s2="B1D23A4A56A";
//          String s1="abc";
//          String s2="abd";
;        System.out.println(LCS(s1,s2));
    }
}
