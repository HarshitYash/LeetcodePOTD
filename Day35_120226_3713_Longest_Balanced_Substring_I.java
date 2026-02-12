public class Day35_120226_3713_Longest_Balanced_Substring_I {
    public boolean isBalance(int[] count){
        int val = 0;
        for(int c : count){
            if(c == 0) continue;
            if(val == 0){
                val = c;
            }else if(val != c){
                return false;
            }
        }
        return true;
    }
    public int longestBalanced(String s) {
        int n = s.length();
        int answer = 1;
        for(int i=0; i<n; i++){
            int[] count = new int[26];
            for(int j=i; j<n; j++){
                count[s.charAt(j)-'a']++;
                if(isBalance(count)){
                    answer = Math.max(answer, j - i + 1);
                }
            }

        }
        return answer;
    }
}
