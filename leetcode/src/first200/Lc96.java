package first200;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class Lc96 {
    public int numTrees(int n) {
        int dp[]=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=0;
            for(int j=0;j<i;j++){
                dp[i]+=dp[j]*dp[i-1-j];
            }
        }
        return dp[n];
    }
    @Test
    public void test(){
        for(int i=1;i<=19;i++){
            System.out.println(numTrees(i));
        }
    }
}
