public class Day1_300726_3014_Minimum_Number_of_Pushes_to_Type_Word_I{
    public int minimumPushes(String word) {
        int count = 0;
        int pushes = 0;
        for(int i = 0; i < word.length(); i++){
            if(i%8 == 0){
                pushes++;
            }
            count += pushes;
        }
        return count;
    }
}