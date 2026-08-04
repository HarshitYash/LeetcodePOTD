class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        int start = nums[0];
        for(int i=0; i<nums.length;i++){
            if(nums[i] != start){
                list.add(start);
                i--;
            }
            start++;
        }
        return list;
    }
}