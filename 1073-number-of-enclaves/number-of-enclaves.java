class Solution {
    class Pair {
        int row;
        int colm;
        Pair(int row ,int colm) {
            this.row = row;
            this.colm = colm;
        }
    }
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(grid[i][0] == 1) {
                grid[i][0] = -1;
                q.add(new Pair(i,0));
            }
            if(grid[i][m-1] == 1) {
                grid[i][m-1] = -1;
                q.add(new Pair(i,m-1));
            }
        }
        for(int i = 0; i < m; i++) {
            if(grid[0][i] == 1) {
                grid[0][i] = -1;
                q.add(new Pair(0,i));
            }
            if(grid[n-1][i] == 1) {
                grid[n-1][i] = -1;
                q.add(new Pair(n-1,i));
            }
        }
        int dr[] = {-1,1,0,0};
        int dc[] = {0,0,1,-1};
        while(!q.isEmpty()) {
            int s = q.size();
            for(int num = 0; num < s; num++ ) {
             Pair curr = q.poll();
             int row = curr.row;
             int colm = curr.colm;
            for(int i = 0; i < 4; i++) {
                int nr = row + dr[i];
                int nc = colm + dc[i];
                if(nr >= 0 && nc >= 0 && nr <n && nc < m && grid[nr][nc] == 1) {
                    grid[nr][nc]  = -1;
                    q.add(new Pair(nr,nc));
                    
                }
            }
            }
        }
        int count = 0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}