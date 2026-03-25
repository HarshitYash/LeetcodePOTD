public class Day76_250326_3546_Equal_Sum_Grid_Partition_I {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(m == 1 & n == 1) return false;
        long[][] verticalSum = new long[m][n];
        long[][] horizontalSum = new long[m][n];
        long current1 = 0;
        long current2 = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                horizontalSum[i][j] = current1 + grid[i][j];
                current1 += grid[i][j];
            }
        }
        if(current1 % 2 == 1) return false;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                verticalSum[j][i] = current2 + grid[j][i];
                current2 += grid[j][i];
            }
        }
        for(int i = 0; i < m; i++){
            if(current1/2 == horizontalSum[i][n-1]){
                return true;
            }
        }
        for(int i = 0; i < n; i++){
            if(current2/2 == verticalSum[m-1][i]){
                return true;
            }
        }
        return false;
    }
}
