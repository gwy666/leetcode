package hot100;

import org.junit.Test;

public class Lc10 {

    public boolean isMatch(String s, String p) {
        int m=s.length();
        int n=p.length();
        boolean dp[][]=new boolean[m+1][n+1];
        dp[0][0]=true;
        for(int i=0;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(p.charAt(j-1)!='*'){
                    if(i>0&&isMatch(s,p,i,j)){
                        dp[i][j]=dp[i-1][j-1];
                    }
                }
                else{
                    dp[i][j]=dp[i][j-2];
                    if(i>0&&isMatch(s,p,i,j-1)){
                        dp[i][j]=dp[i][j]||dp[i-1][j];
                    }
                }
            }
        }
        return dp[m][n];
    }
    public boolean isMatch(String s,String p,int i,int j){

        if(p.charAt(j-1)=='.')return true;
        else return s.charAt(i-1)==p.charAt(j-1);
    }

    @Test
    public void test(){
        String s="aab";
        String p="c*a*b";
        System.out.println(isMatch(s,p));
    }
}
