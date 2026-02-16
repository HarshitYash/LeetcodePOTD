public class Day39_160226_190_Reverse_Bits {
    public int reverseBits(int n) {
        int result = 0;
        for(int i=1; i<=32; i++){
            result <<= 1;
            result |= (n&1);
            n >>>= 1;
        }
        return result;
    }
}
