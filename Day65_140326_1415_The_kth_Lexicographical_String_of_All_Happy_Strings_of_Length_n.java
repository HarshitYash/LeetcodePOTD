public class Day65_140326_1415_The_kth_Lexicographical_String_of_All_Happy_Strings_of_Length_n {
    ArrayList<String> list = new ArrayList<>();
    public String getHappyString(int n, int k) {
        list.clear();
        check(n, "");
        if(list.size() < k) return "";
        return list.get(k-1);
    }
    private void check(int n, String s){
        if(s.length() == n){
            list.add(s);
            return;
        }
        if(s.length() == 0){
            check(n, s + 'a');
            check(n, s + 'b');
            check(n, s + 'c');
            return;
        }
        if(s.charAt(s.length()-1) == 'a'){
            check(n, s + 'b');
            check(n, s + 'c');
        }else if(s.charAt(s.length()-1) == 'b'){
            check(n, s + 'a');
            check(n, s + 'c');
        }else{
            check(n, s + 'a');
            check(n, s + 'b');
        }
    }
}
