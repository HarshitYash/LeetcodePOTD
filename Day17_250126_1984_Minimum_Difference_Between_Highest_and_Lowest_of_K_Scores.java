public class Day17_250126_1984_Minimum_Difference_Between_Highest_and_Lowest_of_K_Scores {
    public int minimumDifference(int[] nums, int k) {
        if(k==1) return 0;
        Arrays.sort(nums);
        int answer = Integer.MAX_VALUE;
        for(int i = 0; i + k - 1 < nums.length; i++){
            answer = Math.min(answer, nums[i + k - 1]-nums[i]);
        }
        return answer;
    }
}
