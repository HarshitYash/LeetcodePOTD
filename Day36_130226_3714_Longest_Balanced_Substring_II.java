public class Day36_130226_3714_Longest_Balanced_Substring_II {
    public int checkCase2(String s, char x, char y){
        int count1 = 0;
        int count2 = 0;
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == x){
                count1++;
            }else if(s.charAt(i) == y){
                count2++;
            }else{
                count1 = 0;
                count2 = 0;
                map = new HashMap<>();
                map.put(0,i);
                continue;
            }

            if(map.containsKey(count1-count2)){
                result = Math.max(result, i - map.get(count1-count2));
            }else{
                map.put(count1-count2, i);
            }
        }
        return result;
    }

    public int checkCase3(String s){
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int result = 0;
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L, -1);
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == 'a'){
                count1++;
            }else if(s.charAt(i) == 'b'){
                count2++;
            }else{
                count3++;
            }
            int d1 = count1 - count2;
            int d2 = count1 - count3;

            long key = ((long)d1 << 32) | (d2 & 0xffffffffL);
            if(map.containsKey(key)){
                result = Math.max(result, i - map.get(key));
            }else{
                map.put(key, i);
            }
        }
        return result;
    }
    public int longestBalanced(String s) {
        int n = s.length();
        int answer = 1;

        //case 1
        int count = 1;
        for(int i=1; i<n; i++){
            if(s.charAt(i) == s.charAt(i-1)){
                count++;
                answer = Math.max(answer, count);
            }else{
                count = 1;
            }
        }

        //case 2
        answer = Math.max(answer, checkCase2(s, 'a', 'b'));
        answer = Math.max(answer, checkCase2(s, 'b', 'c'));
        answer = Math.max(answer, checkCase2(s, 'a', 'c'));

        //case 3
        answer = Math.max(answer, checkCase3(s));

        return answer;
    }
}
