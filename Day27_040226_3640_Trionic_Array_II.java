public class Day27_040226_3640_Trionic_Array_II {
    public long maxSumTrionic(int[] nums) {
        int[] v = nums;

        int low = 1;
        int high = 100000;
        int result = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isValid(v, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    private boolean isValid(int[] nums, int k) {
        long ops = 0;
        long limit = (long) k * k;
        for (int num : nums) {
            ops += (num + k - 1) / k;
            if (ops > limit) return false;
        }
        return ops <= limit;
    }
}
