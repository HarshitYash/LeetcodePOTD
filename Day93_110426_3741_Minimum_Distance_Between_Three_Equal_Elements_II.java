public class Day93_110426_3741_Minimum_Distance_Between_Three_Equal_Elements_II {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        int answer = Integer.MAX_VALUE;
        for(ArrayList<Integer> list : map.values()){
            int size = list.size();
            if(size >= 3){
                for(int i = 0; i < size - 2; i++){
                    int temp = list.get(i + 2) - list.get(i);
                    answer = Math.min(answer, temp);
                }
            }
        }
        return (answer == Integer.MAX_VALUE) ? -1 : 2 * answer;
    }
}
