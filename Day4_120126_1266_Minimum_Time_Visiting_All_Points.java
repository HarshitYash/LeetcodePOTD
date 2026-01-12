public class Day4_120126_1266_Minimum_Time_Visiting_All_Points {
    public int minTimeToVisitAllPoints(int[][] points) {
        int ans = 0;
        for(int i=1; i<points.length; i++){
            if(Math.abs(points[i][0]-points[i-1][0]) > Math.abs(points[i][1]-points[i-1][1])){
                ans += Math.abs(points[i][0]-points[i-1][0]);
            }else{
                ans += Math.abs(points[i][1]-points[i-1][1]);
            }
        }
        return ans;
    }
}
