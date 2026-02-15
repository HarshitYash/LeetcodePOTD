public class Day38_150226_67_Add_Binary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length()-1, j = b.length()-1;
        int carry = 0;
        while(i >= 0 || j>=0){
            char t1, t2;
            if(i < 0) {
                t1='0';
                t2=b.charAt(j);
            }else if(j < 0){
                t1=a.charAt(i);
                t2='0';
            }else{
                t1=a.charAt(i);
                t2=b.charAt(j);
            }
            if(t1 == '1' && t2 == '1'){
                if(carry == 0)
                    sb.insert(0, '0');
                else
                    sb.insert(0, '1');
                carry = 1;
            }else if((t1 == '0' && t2 == '1') || (t1 == '1' && t2 == '0')){
                if(carry == 0)
                    sb.insert(0, '1');
                else{
                    sb.insert(0, '0');
                }
            }else{
                if(carry == 0)
                    sb.insert(0, '0');
                else{
                    sb.insert(0, '1');
                    carry = 0;
                }
            }
            i--;
            j--;
        }
        if(carry == 1) sb.insert(0, '1');
        return sb.toString();
    }
}
