class Solution {
    public int maxJump(int[] stones) {
        int ans = 0;
        if(stones.length == 2){
            return Math.abs(stones[1] - stones[0]);
        }
        for (int i = 2; i < stones.length; i++) {
            ans = Math.max(ans, stones[i] - stones[i - 2]);
        }

        return ans;
        // int n = stones.length;
        // int dp[] = new int[n+1];
        // Arrays.fill(dp,-1);
        // return helper(stones,dp,n-1);
    }
    // public int helper(int stones[] , int dp[] ,int n ) {
    //     if(n == 0) return 0;
    //     if(dp[n] != -1) return dp[n];
    //     int left = helper(stones,dp,n-1) + Math.abs(stones[n] - stones[n-1]);
    //     int right = Integer.MAX_VALUE;
    //     if(n > 1){
    //         right = helper(stones,dp,n-2) + Math.abs(stones[n] -  stones[n-2]);
    //     }
        
    //     return dp[n] = Math.min(left,right);
    // }
}