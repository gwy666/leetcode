package hot100;

import org.junit.Test;

public class Lc64 {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int dp[]=new int[n];
        dp[0]=grid[0][0];
        for(int i=1;i<n;i++){
            dp[i]=dp[i-1]+grid[0][i];
        }
        for(int i=1;i<m;i++){
            dp[0]=dp[0]+grid[i][0];
            int temp=dp[0];
            for(int j=1;j<n;j++){
                dp[j]=Math.min(temp,dp[j])+grid[i][j];
                temp=dp[j];
            }
        }
        return dp[n-1];
    }
    @Test
    public void test(){
        int grid[][]=new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(grid));
    }
}
