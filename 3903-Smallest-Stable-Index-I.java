class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] a1 = new int[n];
        int[] a2 = new int[n];
        int curr1 = nums[0];
        for(int i=0; i<n; i++){
            a1[i] = Math.max(nums[i], curr1);
            curr1 = a1[i];
        }
        int curr2 = nums[n-1];
        for(int i=n-1; i>=0; i--){
            a2[i] = Math.min(nums[i], curr2);
            curr2 = a2[i];
        }
        int ans = -1;
        for(int i=n-1; i>=0; i--){
            int diff = a1[i] - a2[i];
            if(diff <= k){
                ans = i;
            }
        }
        return ans;
    }
}