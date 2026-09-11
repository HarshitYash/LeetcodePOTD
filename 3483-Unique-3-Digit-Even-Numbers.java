class Solution {
    public int totalNumbers(int[] digits) {
        int n = digits.length;
        int[] count = new int[10];
        int answer = 0;
        for(int d : digits){
            count[d]++;
        }
        for(int i = 1; i < 10; i++){
            for(int j = 0; j < 10; j++){
                for(int k = 0; k < 10; k += 2){
                    count[i]--;
                    count[j]--;
                    count[k]--;
                    if(count[i] >= 0 && count[j] >= 0 && count[k] >= 0){
                        answer++;
                    }
                    count[i]++;
                    count[j]++;
                    count[k]++;
                }
            }
        }
        return answer;
    }
}