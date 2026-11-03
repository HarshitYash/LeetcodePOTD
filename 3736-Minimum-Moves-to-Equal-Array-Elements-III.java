class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;
        int count = 0;
        int max = nums[0];
        for(int i = 1; i < n; i++){
            if(max < nums[i]){
                count += i * (nums[i] - max);
                max = nums[i];
            }else{
                count += max - nums[i];
            }
        }
        return count;
    }
}