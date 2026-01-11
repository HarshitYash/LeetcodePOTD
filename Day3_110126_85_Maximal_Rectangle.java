public class Day3_110126_85_Maximal_Rectangle {
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        int[] height = new int[column];
        int answer = 0;

        for(int i=0; i<row; i++){
            for(int j=0; j<column; j++){
                if(matrix[i][j] == '1'){
                    height[j]++;
                }else{
                    height[j] = 0;
                }
            }
            answer = Math.max(answer, calculate(height));
        }
        return answer;
    }
    public int calculate(int[] height){
        int size = height.length;
        int area = 0;
        for(int i=0; i<size; i++){
            int minimum = height[i];
            area = Math.max(area, minimum*1);
            for(int j=i+1; j<size; j++){
                minimum = Math.min(minimum, height[j]);
                area = Math.max(area, minimum*(j-i+1));
            }
        }
        return area;
    }
}
