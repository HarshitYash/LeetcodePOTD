public class Day34_110226_3721_Longest_Balanced_Subarray_II {
    int[] minSeg, maxSeg, lazy;
    int n;
    void propagate(int i, int l, int r) {
        if (lazy[i] != 0) {
            minSeg[i] += lazy[i];
            maxSeg[i] += lazy[i];

            if (l != r) {
                lazy[2 * i + 1] += lazy[i];
                lazy[2 * i + 2] += lazy[i];
            }
            lazy[i] = 0;
        }
    }

    void update(int start, int end, int i, int l, int r, int val) {
        propagate(i, l, r);

        if (l > end || r < start) return;

        if (l >= start && r <= end) {
            lazy[i] += val;
            propagate(i, l, r);
            return;
        }

        int mid = (l + r) / 2;
        update(start, end, 2 * i + 1, l, mid, val);
        update(start, end, 2 * i + 2, mid + 1, r, val);

        minSeg[i] = Math.min(minSeg[2 * i + 1], minSeg[2 * i + 2]);
        maxSeg[i] = Math.max(maxSeg[2 * i + 1], maxSeg[2 * i + 2]);
    }

    int leftestZero(int i, int l, int r) {
        propagate(i, l, r);

        if (minSeg[i] > 0 || maxSeg[i] < 0) return -1;

        if (l == r) return l;

        int mid = l + (r - l) / 2;
        int left = leftestZero(2 * i + 1, l, mid);
        if (left != -1) return left;

        return leftestZero(2 * i + 2, mid + 1, r);
    }

    public int longestBalanced(int[] nums) {
        n = nums.length;
        minSeg = new int[4 * n];
        maxSeg = new int[4 * n];
        lazy = new int[4 * n];

        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            int current = (nums[i]%2 == 0) ? 1 : -1;
            int previous = map.getOrDefault(nums[i], -1);

            if(previous != -1){
                update(0, previous, 0, 0, n-1, -current);
            }
            update(0, i, 0, 0, n-1, current);

            int l = leftestZero(0, 0, n-1);
            if(l != -1){
                answer = Math.max(answer, i - l + 1);
            }
            map.put(nums[i], i);
        }
        return answer;
    }
}
