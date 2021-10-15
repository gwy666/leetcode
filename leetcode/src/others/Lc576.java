package others;

import org.junit.Test;

import java.util.Arrays;

public class Lc576 {

    int MOD = (int)1e9+7;
    int m, n, max;
    int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    int[][][] cache;
    public int findPaths(int _m, int _n, int _max, int r, int c) {
        m = _m; n = _n; max = _max;
        cache = new int[m][n][max + 1];
        int dp[]=new int[m];
        Arrays.fill(dp,-1);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k <= max; k++) {
                    cache[i][j][k] = -1;
                }
            }
        }
        return dfs(r, c, max);
    }
    int dfs(int x, int y, int k) {
        if (x < 0 || x >= m || y < 0 || y >= n) return 1;
        if (k == 0) return 0;
        if (cache[x][y][k] != -1) return cache[x][y][k];
        int ans = 0;
        for (int[] d : dirs) {
            int nx = x + d[0], ny = y + d[1];
            ans += dfs(nx, ny, k - 1);
            ans %= MOD;
        }
        cache[x][y][k] = ans;
        return ans;
    }

    @Test
    public void test(){
        int m = 8, n = 50, maxMove = 23, startRow = 5, startColumn = 26;
        System.out.println(findPaths(m,n,maxMove,startRow,startColumn));
    }
}
