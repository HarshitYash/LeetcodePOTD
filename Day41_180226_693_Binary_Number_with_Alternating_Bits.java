public class Day41_180226_693_Binary_Number_with_Alternating_Bits {
    public boolean hasAlternatingBits(int n) {
        //My code
         if(n == 1) return true;
         int digit = (n&1);
         n >>=1;
         while(n>0){
             int temp = (n&1);
             if(digit == temp){
                 return false;
             }
             digit = temp;
             n >>=1;
         }
         return true;
**********************************************************************

        // Optimized Code
         int x = n ^ (n >> 1);
         return ((x & (x+1)) == 0);
    }
}
