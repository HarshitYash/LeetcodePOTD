class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int target = nums[n / 2];
        int ans = 0;
        for(int num : nums){
            ans += Math.abs(target - num);
        }
        return ans;
    }
}