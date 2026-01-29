public class Day21_290126_2976_Minimum_Cost_to_Convert_String_I {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long[][] minCost = new long[26][26];
        for(long[] mC : minCost){
            Arrays.fill(mC, Integer.MAX_VALUE);
        }
        for(int i =0; i<original.length; i++){
            int src = original[i] - 'a';
            int dest = changed[i] - 'a';
            minCost[src][dest] = Math.min(minCost[src][dest], cost[i]);
        }
        for(int i =0; i<26; i++){
            for(int j =0; j<26; j++){
                for(int k =0; k<26; k++){
                    minCost[j][k] = Math.min(minCost[j][k], minCost[j][i]+minCost[i][k]);
                }
            }
        }
        long answer =0;
        for(int i=0; i<source.length(); i++){
            if(source.charAt(i) == target.charAt(i)) continue;
            int src = source.charAt(i) - 'a';
            int dest = target.charAt(i) - 'a';
            if(minCost[src][dest] == Integer.MAX_VALUE){
                return -1;
            }
            answer += minCost[src][dest];
        }
        return answer;
    }
}
