class Solution {
    class Pair {
        int row;
        int colm;
        Pair(int row ,int colm) {
            this.row = row;
            this.colm = colm;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int freshOranges = 0;
        for(int i = 0; i < n ; i++) {
            for(int j = 0; j < m ; j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i,j));
                }
                if(grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }
        int dr[] = {-1,1,0,0};
        int dc[] = {0,0,1,-1};
        int min = 0;
        while(!q.isEmpty() && freshOranges > 0) {
            int s = q.size();
            
            for(int num = 0; num < s; num++ ) {
             Pair curr = q.poll();
             int row = curr.row;
             int colm = curr.colm;
            for(int i = 0; i < 4; i++) {
                int nr = row + dr[i];
                int nc = colm + dc[i];
                if(nr >= 0 && nc >= 0 && nr < n && nc < m && grid[nr][nc] == 1) {
                    freshOranges--;
                    grid[nr][nc] = 2;
                    q.add(new Pair(nr,nc));
                }
            }
            }
            min++;
        }
        if(freshOranges == 0) return min;
        else return -1;
    }
}