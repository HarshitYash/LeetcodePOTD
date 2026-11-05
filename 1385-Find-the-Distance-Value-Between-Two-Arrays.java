class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int answer = n1;
        for(int i = 0; i < n1; i++){
            for(int j = 0; j < n2; j++){
                if(Math.abs(arr1[i] - arr2[j]) <= d){
                    answer--;
                    break;
                }
            }
        }
        return answer;
    }
}