public class Day33_100226_3719_Longest_Balanced_Subarray_I {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        HashSet<Integer> odd = new HashSet<>();
        HashSet<Integer> even = new HashSet<>();
        int answer = 0;
        for(int i=0; i<n; i++){
            odd.clear();
            even.clear();
            for(int j=i; j<n; j++){
                if(nums[j]%2 == 1) odd.add(nums[j]);
                else even.add(nums[j]);

                if(odd.size() == even.size()){
                    answer = Math.max(answer, j-i+1);
                }
            }
        }
        return answer;
    }
}
