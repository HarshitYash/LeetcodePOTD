class Solution {
    public String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c != ')'){
                stack.push(c);
            }else{
                StringBuilder sb1 = new StringBuilder();
                while(stack.peek() != '('){
                    sb1.append(stack.pop());
                }
                stack.pop();
                for(char c1 : sb1.toString().toCharArray()){
                    stack.push(c1);
                }
            }
        }
        for (char c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}