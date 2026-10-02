class Solution {
    List<String> list;
    public List<String> generateParenthesis(int n) {
        list = new ArrayList<>();
        check(n, 0, 0, new StringBuilder());
        return list;
    }
    private void check(int n, int i, int j, StringBuilder s){
        if(j > i || i > n) return;
        if(i == n && j == n){
            list.add(s.toString());
            return;
        }
        check(n, i + 1, j, new StringBuilder(s).append('('));
        check(n, i, j+1, new StringBuilder(s).append(')'));
    }
}