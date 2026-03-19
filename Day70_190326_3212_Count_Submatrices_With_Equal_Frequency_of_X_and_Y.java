public class Day70_190326_3212_Count_Submatrices_With_Equal_Frequency_of_X_and_Y {
    public int numberOfSubmatrices(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int prefix[][] = new int[m+1][n+1];
        boolean seen[] = new boolean[n+1];

        int count = 0;
        for(int i=1; i<=m; i++) {
            boolean seenRow = false;
            for(int j=1; j<=n; j++) {
                char c = grid[i-1][j-1];
                if(c == 'X') {
                    seen[j] = true;
                }
                if(seen[j])
                    seenRow = true;
                int val = (c == 'X') ? 1 : (c == 'Y') ? -1 : 0;

                prefix[i][j] = val + prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1];
                if(prefix[i][j]==0 && (seen[j] || seenRow))
                    count++;
            }
        }
        return count;
    }
}
