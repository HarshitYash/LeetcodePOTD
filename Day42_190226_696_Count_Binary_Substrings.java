public class Day42_190226_696_Count_Binary_Substrings {
    public int countBinarySubstrings(String s) {
        int previousCount = 0;
        int currentCount = 1;
        int count = 0;
        for(int i=0; i<s.length()-1; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                currentCount++;
            }else{
                count += Math.min(currentCount, previousCount);
                previousCount = currentCount;
                currentCount = 1;
            }
        }
        return count + Math.min(currentCount, previousCount);
    }
}
