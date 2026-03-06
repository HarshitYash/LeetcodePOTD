public class Day57_060326_1784_Check_if_Binary_String_Has_at_Most_One_Segment_of_Ones {
    public boolean checkOnesSegment(String s) {
        int n = s.length();
        int i = 0;
        while(i < n && s.charAt(i) == '1'){
            i++;
        }
        while(i < n && s.charAt(i) == '0'){
            i++;
        }
        return (i == n) ? true : false;
    }
}
