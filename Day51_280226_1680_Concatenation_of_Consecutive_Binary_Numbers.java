public class Day51_280226_1680_Concatenation_of_Consecutive_Binary_Numbers {
    int M = 1_000_000_007;
    public int concatenatedBinary(int n) {
        long answer = 0;
        int digit = 0;
        for(int i=1; i<=n; i++){
            if((i & (i-1)) == 0){
                digit++;
            }
            answer = (((answer << digit) % M) + i) % M;
        }
        return (int)answer;
    }
}
