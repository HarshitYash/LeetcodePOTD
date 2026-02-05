public class Day28_050226_3379_Transformed_Array {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] answer = new int[nums.length];
        for(int i=0; i<n; i++){
            if(nums[i] == 0){
                answer[i] = nums[i];
            }else if(nums[i] < 0){
                int pos = (i - Math.abs(nums[i])) % n;
                if(pos < 0) pos = n + pos;
                answer[i] = nums[pos];
            }else{
                int pos = (i + nums[i])%n;
                answer[i] = nums[pos];
            }
        }
        return answer;
    }
}
