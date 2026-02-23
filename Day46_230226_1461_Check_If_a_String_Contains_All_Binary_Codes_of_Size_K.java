public class Day46_230226_1461_Check_If_a_String_Contains_All_Binary_Codes_of_Size_K {
    public boolean hasAllCodes(String s, int k) {
        HashSet<String> seen = new HashSet<>();
        int requiredCount = (int) Math.pow(2, k);

        for (int i = 0; i <= s.length() - k; i++) {
            seen.add(s.substring(i, i + k));
            if (seen.size() == requiredCount) {
                return true;
            }
        }

        return seen.size() == requiredCount;
    }
}
