public class Day30_070226_1653_Minimum_Deletions_to_Make_String_Balanced {
    /***********************USING STACK************************/
    public int minimumDeletions(String s) {
        int countA = 0, countB = 0;
        int answer = 0;
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == 'b'){
                st.push(c);
            }else if(!st.isEmpty()){
                answer++;
                st.pop();
            }
        }
        return answer;
    }
    /********************USING GREEDY**********************/
    public int minimumDeletions(String s) {
        int countB = 0;
        int answer = 0;
        for(char c : s.toCharArray()){
            if(c == 'b'){
                countB++;
            }else{
                answer = Math.min(countB, answer + 1);
            }
        }
        return answer;
    }
}
