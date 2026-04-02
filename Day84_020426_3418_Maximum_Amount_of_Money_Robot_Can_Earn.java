public class Day84_020426_3418_Maximum_Amount_of_Money_Robot_Can_Earn {
    Integer[][][] dp;
    int m, n;
    public int maximumAmount(int[][] coins) {
        m = coins.length;
        n = coins[0].length;
        dp = new Integer[m][n][3];
        return check(coins, 0, 0, 2);
    }
    int check(int[][] coins, int i, int j, int count){
        if(i >= m || j >= n)
            return Integer.MIN_VALUE;
        if(dp[i][j][count] != null)
            return dp[i][j][count];
        if(i==m-1 && j==n-1){
            if(coins[i][j] < 0 && count > 0)
                return 0;
            return coins[i][j];
        }
        int right = check(coins, i, j+1, count);
        int down = check(coins, i+1, j, count);
        int skip = Integer.MIN_VALUE;
        if(coins[i][j] < 0 && count > 0){
            int downskip = check(coins, i+1, j, count-1);
            int rightskip = check(coins, i, j+1, count-1);
            skip = Math.max(downskip, rightskip);
        }
        int ans = Math.max(Math.max(down, right) + coins[i][j], skip);
        return dp[i][j][count] = ans;
    }
}
