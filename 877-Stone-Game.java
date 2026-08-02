class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[] dp = new int[n];
        for(int i = n - 1; i >= 0; i--){
            dp[i] = piles[i];
            for(int j = i + 1; j < n; j++){
                int left = piles[i] - dp[j];
                int right = piles[j] - dp[j-1];
                dp[j] = Math.max(left, right);
            }
        }
        return dp[n-1] >= 0;
    }
}