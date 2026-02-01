public class Day24_010226_3010_Divide_an_Array_Into_Subarrays_With_Minimum_Cost_I {
    public int minimumCost(int[] nums) {
        int answer = nums[0];
        int minimum1 = 51;
        int minimum2 = 51;
        for(int i=1; i<nums.length; i++){
            if(nums[i] < minimum1){
                minimum2 = minimum1;
                minimum1 = nums[i];
            }else if(nums[i] < minimum2){
                minimum2 = nums[i];
            }
        }
        answer += minimum1 + minimum2;
        return answer;
    }
}
