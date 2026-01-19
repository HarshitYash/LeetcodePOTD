public class Day11_190126_1292_Maximum_Side_Length_of_a_Square_with_Sum_Less_than_or_Equal_to_Threshold {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] pre = new int[m+1][n+1];
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                pre[i][j] = pre[i][j-1] + pre[i-1][j] - pre[i-1][j-1] + mat[i-1][j-1];
            }
        }
        for(int k=Math.min(m,n); k>=1; k--){
            for(int i=1; i+k<m+2; i++){
                for(int j=1; j+k<n+2; j++){
                    if(pre[i+k-1][j+k-1] - pre[i-1][j+k-1] - pre[i+k-1][j-1] + pre[i-1][j-1] <= threshold){
                        return k;
                    }
                }
            }
        }
        return 0;
    }
}
