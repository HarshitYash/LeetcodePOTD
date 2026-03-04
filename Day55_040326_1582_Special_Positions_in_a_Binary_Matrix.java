public class Day55_040326_1582_Special_Positions_in_a_Binary_Matrix {
    public int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int count = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 1){
                    boolean flag = true;

                    for(int k = 0; k < n; k++){
                        if(k != j && mat[i][k] == 1){
                            flag = false;
                            break;
                        }
                    }

                    for(int k = 0; k < m && flag; k++){
                        if(k != i && mat[k][j] == 1){
                            flag = false;
                        }
                    }

                    if(flag) count++;
                }
            }
        }
        return count;
    }
}
