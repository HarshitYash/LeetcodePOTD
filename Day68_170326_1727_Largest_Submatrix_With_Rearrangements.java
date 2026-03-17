public class Day68_170326_1727_Largest_Submatrix_With_Rearrangements {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] height = new int[m][n];
        for(int i=0; i<n; i++){
            height[0][i] = matrix[0][i];
        }
        for(int i=1; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == 1){
                    height[i][j] = height[i-1][j] + 1;
                }else{
                    height[i][j] = 0;
                }
            }
        }
        int maxArea = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                System.out.print(height[i][j] + " ");
            }
            System.out.println();
        }
        for(int i=0; i<m; i++){
            int[] row = height[i].clone();
            Arrays.sort(row);
            for(int j=0; j<n; j++){
                int width = n - j;
                int area = width * row[j];
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }
}
