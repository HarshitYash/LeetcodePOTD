public class Day16_240126_1877_Minimize_Maximum_Pair_Sum_in_Array {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int i=0, j=nums.length-1;
        int answer = 0;
        while(i<j){
            answer = Math.max(answer, nums[i++]+nums[j--]);
        }
        return answer;
    }
}
