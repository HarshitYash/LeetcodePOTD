public class Day10_180126_1895_Largest_Magic_Square {
    public int largestMagicSquare(int[][] grid) {
        int R = grid.length, C = grid[0].length;

        int[][] rp = new int[R][C + 1];
        int[][] cp = new int[R + 1][C];
        int[][] d1 = new int[R + 1][C + 1];
        int[][] d2 = new int[R + 1][C + 1];

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                rp[r][c + 1] = rp[r][c] + grid[r][c];
                cp[r + 1][c] = cp[r][c] + grid[r][c];
                d1[r + 1][c + 1] = d1[r][c] + grid[r][c];
                d2[r + 1][c] = d2[r][c + 1] + grid[r][c];
            }
        }

        for (int sz = Math.min(R, C); sz >= 2; sz--) {
            for (int r0 = 0; r0 + sz <= R; r0++) {
                for (int c0 = 0; c0 + sz <= C; c0++) {

                    int tgt = rp[r0][c0 + sz] - rp[r0][c0];
                    boolean ok = true;

                    for (int r = r0; r < r0 + sz && ok; r++)
                        if (rp[r][c0 + sz] - rp[r][c0] != tgt) ok = false;

                    for (int c = c0; c < c0 + sz && ok; c++)
                        if (cp[r0 + sz][c] - cp[r0][c] != tgt) ok = false;

                    if (!ok) continue;

                    int a = d1[r0 + sz][c0 + sz] - d1[r0][c0];
                    int b = d2[r0 + sz][c0] - d2[r0][c0 + sz];

                    if (a == tgt && b == tgt) return sz;
                }
            }
        }
        return 1;
    }
}
