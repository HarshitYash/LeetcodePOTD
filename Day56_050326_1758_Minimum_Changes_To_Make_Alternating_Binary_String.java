public class Day56_050326_1758_Minimum_Changes_To_Make_Alternating_Binary_String {
    public int minOperations(String s) {
        int n = s.length();
        int count1 = 0;
        int count2 = 0;
        for(int i=0; i<n; i++){
            char t1 = (i%2 == 0) ? '0' : '1';
            char t2 = (i%2 != 0) ? '0' : '1';

            if(s.charAt(i) == t1) count1++;
            else count2++;
        }
        return Math.min(count1, count2);
    }
}
