public class Day83_010426_2751_Robot_Collisions {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        ArrayList<Integer> currentPos = new ArrayList<>();
        for(int i=0; i<n; i++){
            currentPos.add(i);
        }
        Collections.sort(currentPos, (a,b) -> positions[a] - positions[b]);
        Stack<Integer> stack = new Stack<>();
        for(int i : currentPos){
            if(directions.charAt(i) == 'R'){
                stack.push(i);
                continue;
            }
            while(!stack.isEmpty() && healths[i] > 0){
                int next = stack.peek();
                if(healths[next] > healths[i]){
                    healths[next] -= 1;
                    healths[i] = 0;
                }else if(healths[next] < healths[i]){
                    healths[next] = 0;
                    healths[i] -= 1;
                    stack.pop();
                }else{
                    healths[next] = 0;
                    healths[i] = 0;
                    stack.pop();
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int h : healths){
            if(h > 0){
                list.add(h);
            }
        }
        return list;
    }
}
