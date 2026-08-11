class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int m = isConnected[0].length;
        boolean v[] = new boolean[n];
        int c = 0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++){
                if(!v[i]) {
                    bfs(i,isConnected,v);
                    c++;
                }
            }
        }
        return c;
    }
    public void bfs(int s , int[][] isConnected , boolean v[]) {
        v[s] = true;
        for(int i=0;i<isConnected.length;i++) {
            if(v[i]!= true && isConnected[s][i] == 1) {
                v[i] = true;
                bfs(i,isConnected,v);
            }
        }
    }
}