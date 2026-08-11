class Solution {
    class Triplet {
        int row;
        int colm;
        int dist;
        Triplet(int row ,int colm ,int dist) {
            this.row = row;
            this.colm = colm;
            this.dist = dist;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Queue<Triplet> q = new LinkedList<>();
       
        int ans[][] = new int[n][m];
        boolean vis[][] = new boolean[n][m];
         for(int i=0;i<n;i++) {
            for(int j = 0; j < m ;j++) {
                if(mat[i][j] == 0){
                    vis[i][j] = true;
                    q.add(new Triplet(i,j,0));
                }
            }
        }
        int dr[] = {-1,1,0,0};
        int dc[] = {0,0,1,-1};
        while(!q.isEmpty()) {
            int s= q.size();
            for(int i=0;i<s;i++) {
                Triplet curr= q.poll();
                int row =curr.row;
                int colm = curr.colm;
                int dis= curr.dist;
                ans[row][colm] = dis;
                for(int j=0;j<4;j++) {
                    int nr= row + dr[j];
                    int nc = colm + dc[j];
                    if(nc>=0 && nr>=0 && nc<m && nr<n && !vis[nr][nc]){
                        vis[nr][nc] = true;
                        q.add(new Triplet (nr,nc,dis+1));
                    }
                }
            }

        }   
        return ans;
    }
}