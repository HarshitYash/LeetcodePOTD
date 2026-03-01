public class Day52_010326_1689_Partitioning_Into_Minimum_Number_Of_Deci_Binary_Numbers {
    public int minPartitions(String n) {
        int answer = 1;
        for(char c : n.toCharArray()){
            answer = Math.max(answer, c - '0');
        }
        return answer;
    }
}
