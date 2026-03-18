public class Day69_180326_3070_Count_Submatrices_with_TopLeft_Element_and_Sum_Less_Than_k {
    public int countSubmatrices(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] preSum = new int[m+1][n+1];
        int count = 0;
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                preSum[i][j] = grid[i-1][j-1] + preSum[i-1][j] + preSum[i][j-1] - preSum[i-1][j-1];
                if(preSum[i][j] <= k){
                    count++;
                }
            }
        }
        return count;
    }
}
