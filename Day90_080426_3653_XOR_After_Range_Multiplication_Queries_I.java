public class Day90_080426_3653_XOR_After_Range_Multiplication_Queries_I {
    int mod = 1_000_000_007;
    public int xorAfterQueries(int[] nums, int[][] queries) {
        for (int[] q : queries) {
            int ind = q[0];
            int r = q[1];
            int k = q[2];
            long v = q[3];
            while (ind <= r) {
                long curr = nums[ind];
                curr = (curr * v) % mod;
                nums[ind] = (int) curr;
                ind += k;
            }
        }
        int xor = 0;
        for (int num : nums) {
            xor = xor ^ num;
        }
        return xor;
    }
}
