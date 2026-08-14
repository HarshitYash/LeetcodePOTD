class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int answer = 1;
        while(i <= j && j < n){
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            while(map.get(s.charAt(j)) > 2){
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) - 1);
                i++;
            }
            answer = Math.max(answer, j - i + 1);
            j++;
        }
        return answer;
    }
}