class Solution {
    public HashMap<Integer,Integer> map = new HashMap<>();
    public byte t[][];
    public int n;
    public boolean canCross(int[] stones) {
        n= stones.length;
        for(int i=0;i<n;i++) {
          map.put(stones[i],i);
        }
        t = new byte[n][n+1];
        
        
        return solve(stones,0,0);
    }
    public boolean solve(int stones[] , int curr_idx ,int prev_jump) {
        if(curr_idx == n - 1) return true;
        if(t[curr_idx][prev_jump] != 0) return t[curr_idx][prev_jump ] == 2;
        boolean ans = false;
        for(int nextJump  = prev_jump - 1 ; nextJump <= prev_jump + 1; nextJump++ ) {
            if(nextJump > 0 ){
                int nextStone =  stones[curr_idx] + nextJump;
                if(map.containsKey(nextStone)) {
                   if(solve(stones, map.get(nextStone), nextJump)) {
                    ans = true;
                    break;
                }
                }
            }
        }
        t[curr_idx][prev_jump] = ans ? (byte)2 :(byte)1;
        return ans;
    }
}