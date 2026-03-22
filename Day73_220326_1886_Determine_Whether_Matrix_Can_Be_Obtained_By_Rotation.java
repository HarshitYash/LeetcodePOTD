public class Day73_220326_1886_Determine_Whether_Matrix_Can_Be_Obtained_By_Rotation {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        boolean r1 = true, r2 = true, r3 = true, r4 = true;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] != target[i][j]){
                    r1 = false;
                }
                if(mat[i][j] != target[j][n - 1 - i]){
                    r2 = false;
                }
                if(mat[i][j] != target[n - 1 - i][n - 1 - j]){
                    r3 = false;
                }
                if(mat[i][j] != target[n - 1 - j][i]){
                    r4 = false;
                }
            }
        }
        return (r1 || r2 || r3 || r4);
    }
}
