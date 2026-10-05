class Solution {
    public int scoreOfParentheses(String s) {
        int count = 0;
        int answer = 0;
        for(int i = 0; i < s.length(); i++ ){
            if(s.charAt(i) == '('){
                count++;
            }else{
                count--;
                if(s.charAt(i-1) == '('){
                    answer += Math.pow(2, count);
                }
            }
        }
        return answer;
    }
}