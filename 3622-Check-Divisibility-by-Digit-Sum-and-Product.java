class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0;
        int mul = 1;
        int temp = n;
        while(temp > 0){
            int digit = temp % 10;
            sum += digit;
            mul *= digit;
            temp /= 10;
        }
        return n % (sum + mul) == 0;
    }
}