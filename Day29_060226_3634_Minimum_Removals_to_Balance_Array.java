public class Day29_060226_3634_Minimum_Removals_to_Balance_Array {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int i = 0, j = 0;
        int answer = n;
        while(i < n){
            while(j < n && nums[j] <= (long)k * nums[i]){
                j++;
            }
            answer = Math.min(answer, n - (j - i));
            i++;
        }
        return answer;
    }
}
