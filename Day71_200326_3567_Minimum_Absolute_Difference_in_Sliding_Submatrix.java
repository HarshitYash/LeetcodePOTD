public class Day71_200326_3567_Minimum_Absolute_Difference_in_Sliding_Submatrix {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] answer = new int[m-k+1][n-k+1];
        for(int i = 0; i < m-k+1; i++){
            for(int j = 0; j < n-k+1; j++){
                TreeSet<Integer> set = new TreeSet<>();
                for(int r = i; r < i+k; r++){
                    for(int c = j; c <j+k; c++){
                        set.add(grid[r][c]);
                    }
                }
                int min = Integer.MAX_VALUE;
                int last = set.first();
                for(int val : set){
                    if(val != last){
                        min = Math.min(min, val - last);
                        last = val;
                    }
                }
                answer[i][j] = (min == Integer.MAX_VALUE) ? 0 : min;
            }
        }
        return answer;
    }
}
