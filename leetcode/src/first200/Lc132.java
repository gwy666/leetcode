package first200;

import org.junit.Test;

public class Lc132 {

    public int minCut(String s) {
        int n=s.length();
        boolean f[][]=new boolean[n][n];
        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                if(i==j)f[i][j]=true;
                else if(i+1==j)f[i][j]=s.charAt(i)==s.charAt(j);
                else {
                    f[i][j]=f[i+1][j-1]&&s.charAt(i)==s.charAt(j);
                }
            }
        }

        int dp[]=new int[n];
        dp[0]=0;
        for(int i=1;i<n;i++){
            dp[i]=dp[i-1]+1;

            for(int j=1;j<i;j++){
                if(f[j][i]){
                    dp[i]=Math.min(dp[j-1]+1,dp[i]);
                }
            }
            if(f[0][i]){
                dp[i]=0;
            }
        }
        return dp[n-1];
    }

    @Test
    public void test(){
        String s="efe";
        System.out.println(minCut(s));
    }
}
