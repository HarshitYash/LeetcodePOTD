public class Day79_280326_2573_Find_the_String_with_LCP {
    public String findTheString(int[][] lcp) {
        int n = lcp.length;
        char[] s = new char[n];
        char ch = 'a';
        for(int i=0; i<n; i++){
            if(s[i] > 0) continue;
            if(ch > 'z') return "";
            s[i] = ch;
            for(int j=i+1; j<n; j++){
                if(lcp[i][j] > 0) s[j] = s[i];
            }
            ch++;
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int pre = 0;
                if(s[i] == s[j]){
                    int p = 0;
                    if(i == n-1 || j == n-1)
                        p = 0;
                    else
                        p = lcp[i+1][j+1];
                    pre = p + 1;
                }else
                    pre = 0;
                if(pre != lcp[i][j])
                    return "";
            }
        }
        return String.valueOf(s);
    }
}
