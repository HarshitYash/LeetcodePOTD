public class Day26_030226_3637_Trionic_Array_I {
    public boolean isTrionic(int[] nums){
        int n = nums.length;
        if(n == 3) return false;
        int[] pattern = new int[3];
        int j = 0;
        boolean prev = false;
        for(int i=1; i<nums.length; i++){
            int temp = nums[i] - nums[i-1];
            if(temp == 0) return false;
            if((temp > 0 && !prev) || (temp < 0 && prev)){
                if(i != 1) j++;
                prev = !prev;
            }
            if(j >= 3) return false;
            pattern[j] += temp;
        }
        if(j != 2) return false;
        if(pattern[0] <= 0 || pattern[1] >= 0 || pattern[0] <= 0) return false;
        return true;
    }
}
