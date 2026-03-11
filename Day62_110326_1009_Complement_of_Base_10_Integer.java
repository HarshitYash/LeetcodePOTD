public class Day62_110326_1009_Complement_of_Base_10_Integer {
    public int bitwiseComplement(int n) {
        if(n == 0) return 1;
        long temp = n;
        long mask = 0;
        while(temp > 0){
            mask = (mask << 1) | 1;
            temp >>= 1;
        }
        return (int)mask ^ n;
    }
}
