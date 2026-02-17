public class Day40_170226_401_Binary_Watch {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> list = new ArrayList<>();
        for(int h=0; h<12; h++){
            for(int m=0; m<60; m++){
                if(Integer.bitCount(h) + Integer.bitCount(m) == turnedOn){
                    StringBuilder sb = new StringBuilder();
                    sb.append(h).append(':');
                    if(m < 10){
                        sb.append('0');
                    }
                    sb.append(m);
                    list.add(sb.toString());
                }
            }
        }
        return list;
    }
}
