public class Day14_220126_3507_Minimum_Pair_Removal_to_Sort_Array_I {
    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        int count = 0;
        List<Integer> list = new ArrayList<>();
        for(int num : nums){
            list.add(num);
        }
        while(!isSorted(list)){
            int minimum = Integer.MAX_VALUE;
            int index = 0;
            for(int i=0; i<list.size()-1; i++){
                if(list.get(i)+list.get(i+1) < minimum){
                    minimum = list.get(i)+list.get(i+1);
                    index = i;
                }
            }
            list.remove(index);
            list.remove(index);
            list.add(index, minimum);
            count++;
        }
        return count;
    }
    public boolean isSorted(List<Integer> list){
        for(int i=0; i<list.size()-1; i++){
            if(list.get(i) > list.get(i+1)){
                return false;
            }
        }
        return true;
    }
}
