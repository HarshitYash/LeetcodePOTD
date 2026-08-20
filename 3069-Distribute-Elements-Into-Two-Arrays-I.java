class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        int first = nums[0];
        int second = nums[1];
        int a1 = 1;
        for(int i = 2; i < n; i++){
            if(first > second){
                int temp = nums[i];
                for(int j = i; j > a1; j--){
                    nums[j] = nums[j-1];
                }
                nums[a1] = temp;
                a1++;
                first = temp;
            }else{
                second = nums[i];
            }
        }
        return nums;
    }
}