class Solution {
    public boolean checkString(String s) {
        int n = s.length();
        boolean isFound = false;
        int count = 0;
        for(int i = n-1; i>= 0; i--){
            if(s.charAt(i) == 'b'){
                if(count == 0){
                    isFound = true;
                }else{
                    return false;
                }
            }else{
                count++;
            }
        }
        return true;
    }
}