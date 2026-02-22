public class Day45_220226_868_Binary_Gap {
    public int binaryGap(int n) {
        int count = 1;
        boolean isFound = false;
        int answer = 0;
        while(n > 0){
            int bit = n&1;
            if(bit == 0){
                if(isFound) count++;
            }else{
                if(!isFound){
                    isFound = true;
                }else{
                    answer = Math.max(answer, count);
                    count = 1;
                }
            }
            n >>= 1;
        }
        return answer;
    }
}
