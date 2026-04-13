public class Day95_130426_1848_Minimum_Distance_to_the_Target_Element {
    public int getMinDistance(int[] nums, int target, int start) {
        int n = nums.length;
        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            if(nums[i] == target){
                answer = Math.min(answer, Math.abs(i - start));
            }
        }
        return answer;
    }
}
