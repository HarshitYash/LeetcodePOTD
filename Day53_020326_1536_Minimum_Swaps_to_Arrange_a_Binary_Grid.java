public class Day53_020326_1536_Minimum_Swaps_to_Arrange_a_Binary_Grid {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] zero = new int[n];
        for(int i=0; i<n; i++){
            int count = 0;
            for(int j=n-1; j>=0 && grid[i][j] == 0; j--){
                count++;
            }
            zero[i] = count;
        }
        int answer = 0;
        for(int i=0; i<n; i++){
            int need = n - i - 1;
            int j = i;
            while(j<n && need > zero[j]){
                j++;
            }
            if(j == n) return -1;
            while(j>i){
                int temp = zero[j-1];
                zero[j-1] = zero[j];
                zero[j] = temp;
                j--;
                answer++;
            }
        }
        return answer;
    }
}
