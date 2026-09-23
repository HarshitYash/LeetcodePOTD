class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        long total = 0;
        for(int num : nums){
            total += num;
        }
        long target = total - x;
        if(target < 0) return -1;
        if(target == 0) return n;
        long current = 0;
        int minimum = -1;
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L, -1);
        for(int i = 0; i < n; i++){
            current += nums[i];
            if(map.containsKey(current - target)){
                minimum = Math.max(minimum, i - map.get(current - target));
            }
            map.putIfAbsent(current, i);
        }
        return minimum == -1 ? -1 : n - minimum;
    }
}