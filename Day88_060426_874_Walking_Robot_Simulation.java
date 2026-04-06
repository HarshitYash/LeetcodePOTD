public class Day88_060426_874_Walking_Robot_Simulation {
    public int robotSim(int[] commands, int[][] obstacles) {
        HashSet<String> set = new HashSet<>();
        for(int o[] : obstacles){
            set.add(o[0] + "," + o[1]);
        }
        int x = 0, y=0;
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
        int current = 0;
        int answer = 0;
        for(int c : commands){
            if(c == -1){
                current = (current + 1) % 4;
            }else if(c == -2){
                current = (current + 3) % 4;
            }else{
                for(int i = 0; i < c; i++) {
                    String key = (x + dir[current][0]) + "," + (y + dir[current][1]);
                    if(set.contains(key))
                        break;
                    else{
                        x = x + dir[current][0];
                        y = y + dir[current][1];
                    }
                }
                answer = Math.max(answer, (x*x) + (y*y));
            }
        }
        return answer;
    }
}
