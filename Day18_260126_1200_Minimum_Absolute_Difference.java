public class Day18_260126_1200_Minimum_Absolute_Difference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int minimum = Integer.MAX_VALUE;
        for(int i = 1; i < n; i++){
            minimum = Math.min(minimum, arr[i]-arr[i-1]);
        }
        List<List<Integer>> answer = new ArrayList<>();
        for(int i = 1; i < n; i++){
            if((arr[i] - arr[i-1]) == minimum){
                answer.add(new ArrayList<>(List.of(arr[i-1], arr[i])));
            }
        }
        return answer;
    }
}
