public class Day7_150126_2943_Maximize_Area_of_Square_Hole_in_Grid {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int h = maximumCount(hBars);
        int v = maximumCount(vBars);
        int side = Math.min(h+1,v+1);
        return side*side;
    }
    public int maximumCount(int[] arr){
        int count = 1;
        int answer = 1;
        for(int i=0; i<arr.length-1; i++){
            if(arr[i] == arr[i+1] - 1){
                count++;
            }else{
                count =1;
            }
            answer = Math.max(answer, count);
        }
        return answer;
    }
}
