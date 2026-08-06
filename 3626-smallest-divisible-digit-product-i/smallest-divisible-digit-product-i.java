class Solution {
    public int smallestNumber(int n, int t) {
        int num = n;
        int product = 1;
        while(num > 0) {
            int rem  = num % 10;
            product = product * rem;
            num = num / 10;
        }
        num = n;
        if(product % t == 0) return num;
        else return smallestNumber(n+1,t);
    }
}