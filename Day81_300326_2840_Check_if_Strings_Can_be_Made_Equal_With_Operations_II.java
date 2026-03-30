public class Day81_300326_2840_Check_if_Strings_Can_be_Made_Equal_With_Operations_II {
    public boolean checkStrings(String s1, String s2) {
        int n = s1.length();
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(int i=0; i<n; i++){
            char c = s1.charAt(i);
            if(i%2 == 0)
                map1.put(c, map1.getOrDefault(c,0) + 1);
            else
                map2.put(c, map2.getOrDefault(c,0) + 1);
        }
        for(int i=0; i<n; i++){
            char c = s2.charAt(i);
            if(i%2 == 0)
                map1.put(c, map1.getOrDefault(c,0) - 1);
            else
                map2.put(c, map2.getOrDefault(c,0) - 1);
        }
        for(int val : map1.values()){
            if(val != 0) return false;
        }
        for(int val : map2.values()){
            if(val != 0) return false;
        }
        return true;
    }
}
