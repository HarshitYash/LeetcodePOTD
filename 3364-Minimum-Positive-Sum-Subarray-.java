class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int answer = Integer.MAX_VALUE;
        for(int i = l; i <= r; i++){
            int a = 0, j = 0;
            int sum = 0;
            while(j < n){
                sum += nums.get(j);
                if(j - a + 1 == i){
                    if(sum > 0)
                        answer = Math.min(answer, sum);
                    sum -= nums.get(a++);
                }
                j++;
            }
        }
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}