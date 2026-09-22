class Solution {
    public int reverseDegree(String s) {
        int rev = 1;
        int sum = 0;

        int idxs = 1;
        for(int i=1;i<=s.length();i++) {
            int product = 1;
            char ch = s.charAt(i-1);
            rev = i;
            idxs = 26 - (ch-'a'); 
            product = rev * idxs;
            sum += product;
        }
        return sum;
    }
}