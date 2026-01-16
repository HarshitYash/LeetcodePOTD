public class Day8_160126_2975_Maximum_Square_Area_by_Removing_Fences_From_a_Field {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        int[] h = new int[hFences.length+2];
        int[] v = new int[vFences.length+2];
        h[0] = v[0] = 1;
        h[h.length-1] = m;
        v[v.length-1] = n;
        for(int i=1; i<h.length-1; i++){
            h[i] = hFences[i-1];
        }
        for(int i=1; i<v.length-1; i++){
            v[i] = vFences[i-1];
        }
        Arrays.sort(h);
        Arrays.sort(v);

        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<h.length-1; i++){
            for(int j=i+1; j<h.length; j++){
                set.add(h[j] - h[i]);
            }
        }
        long answer = -1;
        for(int i=0; i<v.length-1; i++){
            for(int j=i+1; j<v.length; j++){
                if(set.contains(v[j] - v[i])){
                    answer = Math.max(answer, v[j] - v[i]);
                }
            }
        }
        if(answer == -1) return -1;
        return (int)((answer*answer) % 1000000007);
    }
}
