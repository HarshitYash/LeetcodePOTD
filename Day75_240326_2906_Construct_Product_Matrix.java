public class Day75_240326_2906_Construct_Product_Matrix {
    public int[][] constructProductMatrix(int[][] grid) {
        int mod = 12345;
        int n = grid.length;
        int m = grid[0].length;
        long productL = 1, productR = 1;
        int[][] answer = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                answer[i][j] = (int)productL;
                productL = (productL * grid[i][j]) % mod;
            }
        }
        for(int i=n-1; i>=0; i--){
            for(int j=m-1; j>=0; j--){
                answer[i][j] = (int)(productR * answer[i][j]) % mod;
                productR = (productR * grid[i][j]) % mod;
            }
        }
        return answer;
    }
}
