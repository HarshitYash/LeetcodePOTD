class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n+1][m+1];
        for(int i = 0; i <= n; i++){
            dp[i][0] = Integer.MAX_VALUE;
        }
        for(int j = 0; j <= m; j++){
            dp[0][j] = Integer.MAX_VALUE;
        }
        dp[0][1] = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j]) + grid[i-1][j-1];
            }
        }
        return dp[n][m];
    }
}