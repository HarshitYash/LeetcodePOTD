public class Day58_070326_1888_Minimum_Number_of_Flips_to_Make_the_Binary_String_Alternating {
    public int minFlips(String s) {
        String t = s + s;
        int n = s.length();
        int answer = Integer.MAX_VALUE;
        int a = 0, b = 0;

        for(int i = 0; i < 2*n; i++) {
            char c = t.charAt(i);

            if(i % 2 == 0) {
                if(c == '0')
                    a++;
                else b++;
            }
            else {
                if(c == '0')
                    b++;
                else a++;
            }

            if(i >= n-1) {
                answer = Math.min(answer, Math.min(b, a));

                int j = i - n + 1;
                char p = t.charAt(j);

                if(j % 2 == 0) {
                    if(p == '0')
                        a--;
                    else b--;
                }
                else {
                    if(p == '0')
                        b--;
                    else a--;
                }
            }
        }

        return answer;
    }
}
