public class Day25_020226_3013_Divide_an_Array_Into_Subarrays_With_Minimum_Cost_II {
    public long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;
        int need = k - 1;

        TreeMap<Integer, Integer> x1 = new TreeMap<>();
        TreeMap<Integer, Integer> x2 = new TreeMap<>();

        long sum = 0;
        long ans = Long.MAX_VALUE;

        int size1 = 0;
        int l = 1;

        for (int r = 1; r < n; r++) {

            x1.put(nums[r], x1.getOrDefault(nums[r], 0) + 1);
            sum += nums[r];
            size1++;

            while (size1 > need) {
                int mx = x1.lastKey();
                x1.put(mx, x1.get(mx) - 1);
                if (x1.get(mx) == 0) x1.remove(mx);

                x2.put(mx, x2.getOrDefault(mx, 0) + 1);
                sum -= mx;
                size1--;
            }

            while (r - l > dist) {

                if (x1.containsKey(nums[l])) {
                    x1.put(nums[l], x1.get(nums[l]) - 1);
                    if (x1.get(nums[l]) == 0) x1.remove(nums[l]);
                    sum -= nums[l];
                    size1--;
                } else {
                    x2.put(nums[l], x2.get(nums[l]) - 1);
                    if (x2.get(nums[l]) == 0) x2.remove(nums[l]);
                }

                l++;

                while (size1 < need && !x2.isEmpty()) {
                    int mn = x2.firstKey();
                    x2.put(mn, x2.get(mn) - 1);
                    if (x2.get(mn) == 0) x2.remove(mn);

                    x1.put(mn, x1.getOrDefault(mn, 0) + 1);
                    sum += mn;
                    size1++;
                }
            }

            if (r - l + 1 >= need) {
                ans = Math.min(ans, sum);
            }
        }

        return ans + nums[0];
    }
}
