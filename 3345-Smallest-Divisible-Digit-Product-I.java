class Solution {
    public int smallestNumber(int n, int t) {
        while(check(n) % t != 0){
            n++;
        }
        return n;
    }
    public int check(int n){
        int multi = 1;
        while(n != 0){
            multi *= n % 10;
            n /= 10;
        }
        return multi;
    }
}