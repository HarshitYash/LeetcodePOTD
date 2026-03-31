public class Day82_310326_3474_Lexicographically_Smallest_Generated_String {
    public String generateString(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int size = n + m - 1;
        char[] word = new char[size];
        boolean[] canChange = new boolean[size];
        for(int i = 0; i < size; i++){
            word[i] = '*';
        }
        for(int i = 0; i < n; i++) {
            if(str1.charAt(i) == 'T'){
                int t = i;
                for (int j = 0; j < m; j++) {
                    if (word[t] != '*' && word[t] != str2.charAt(j)) {
                        return "";
                    }
                    word[t] = str2.charAt(j);
                    t++;
                }
            }
        }
        for(int i = 0; i < size; i++){
            if(word[i] == '*'){
                word[i] = 'a';
                canChange[i] = true;
            }
        }
        for(int i = 0; i < n; i++){
            if(str1.charAt(i) == 'F'){
                if(isSame(word, str2, i, m)){
                    boolean changed = false;
                    for(int k = i + m - 1; k >= i; k--){
                        if(canChange[k]){
                            word[k] = 'b';
                            canChange[k] = false;
                            changed = true;
                            break;
                        }
                    }
                    if (!changed)
                        return "";
                }
            }
        }

        return new String(word);
    }

    private boolean isSame(char[] word, String str2, int i, int m) {
        for (int j = 0; j < m; j++) {
            if (word[i] != str2.charAt(j)) return false;
            i++;
        }
        return true;
    }
}
