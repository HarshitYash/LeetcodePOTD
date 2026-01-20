public class Day12_200126_3314_Construct_the_Minimum_Bitwise_Array_I {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] answer = new int[n];
        for(int i=0; i<n; i++){
            if(nums.get(i) == 2){
                answer[i] = -1;
                continue;
            }
            for(int j=1; j<32; j++){
                if( (nums.get(i) & (1<<j)) == 0){
                    answer[i] = nums.get(i)^(1 << (j-1));
                    break;
                }
            }
        }
        return answer;
    }
}
