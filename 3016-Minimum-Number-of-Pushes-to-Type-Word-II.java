class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];
        for(char c : word.toCharArray()){
            freq[c-'a']++;
        }
        Arrays.sort(freq);
        int pushes = 0;
        int count = 0;
        int answer = 0;
        for(int i = 25; i >= 0; i--){
            if(freq[i] == 0) continue;
            if(count % 8 == 0) pushes++;
            answer += pushes * freq[i];
            count++;
        }
        return answer;
    }
}