public class Day64_130326_3296_Minimum_Number_of_Seconds_to_Make_Mountain_Height_Zero {
    private boolean check(long i, int h, int[] times){
        long ans = 0;
        for(int t : times){
            ans += (long)( Math.sqrt( (2.0 * i)/t + 0.25) - 0.5);
            if(ans >= h){
                return true;
            }
        }
        return ans >= h;
    }
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        int n = workerTimes.length;
        int maxTime = 0;
        for(int w : workerTimes){
            maxTime = Math.max(maxTime, w);
        }
        long s = 1;
        long e = (long)maxTime * mountainHeight * (mountainHeight + 1) / 2;
        long answer = 0;
        while(s <= e){
            long mid = s + (e - s) / 2;
            if(check(mid, mountainHeight, workerTimes)){
                answer = mid;
                e = mid - 1;
            }else{
                s = mid + 1;
            }
        }
        return answer;
    }
}
