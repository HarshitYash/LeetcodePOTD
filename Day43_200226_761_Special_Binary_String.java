public class Day43_200226_761_Special_Binary_String {
    public String makeLargestSpecial(String s) {
        ArrayList<String> list = new ArrayList<>();
        int sum = 0;
        int j = 0;
        for(int i=0; i<s.length(); i++){
            sum += (s.charAt(i) == '1') ? 1 : -1 ;
            if(sum == 0){
                String subSpecial = s.substring(j+1, i);
                String changed = "1" + makeLargestSpecial(subSpecial) + "0";
                list.add(changed);
                j = i+1;
            }
        }
        Collections.sort(list, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for(String t : list){
            sb.append(t);
        }
        return sb.toString();
    }
}
