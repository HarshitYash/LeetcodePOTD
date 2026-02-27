public class Day49_260226_1404_Number_of_Steps_to_Reduce_a_Number_in_Binary_Representation_to_One {
    public int numSteps(String s){
        int n = s.length();
        int count = 0;
        int carry = 0;
        for(int i = n-1; i > 0; i--){
            int bit = s.charAt(i) - '0';
            if(bit + carry == 1){
                count += 2;
                carry = 1;
            }else{
                count += 1;
            }
        }
        return count + carry;
    }
}
