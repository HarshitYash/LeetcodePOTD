public class Day59_080326_1980_Find_Unique_Binary_String {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        char[] c = new char[n];
        for(int i=0; i<n; i++){
            c[i] = nums[i].charAt(i) == '1' ? '0' : '1';
        }
        return new String(c);
    }
}
