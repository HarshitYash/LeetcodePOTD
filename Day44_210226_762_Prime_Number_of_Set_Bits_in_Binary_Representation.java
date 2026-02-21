public class Day44_210226_762_Prime_Number_of_Set_Bits_in_Binary_Representation {
    public int countPrimeSetBits(int left, int right) {
        int count = 0;
        int mask = 0b10100010100010101100;
        for(int i = left; i <= right; i++){
            int bit = Integer.bitCount(i);
            if(((1 << bit) & (mask)) != 0){
                count++;
            }
        }
        return count;
    }
}
