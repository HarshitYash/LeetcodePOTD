class Solution {
    int start = 0, end = 0, max = 0;
    private boolean check(String s, int i, int j){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }else{
                i++;
                j--;
            }
        }
        return true;
    }
    public String longestPalindrome(String s) {
        int n = s.length();
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if(check(s, i, j)){
                    if(j - i + 1 > max){
                        start = i;
                        end = j + 1;
                        max = j - i + 1;
                    }
                }
            }
        }
        return s.substring(start, end);
    }
}