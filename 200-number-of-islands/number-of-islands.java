class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == '1') {
                    count++;             
                    dfs(i,j,grid);
                }
            }
        }
        return count;
    }
    public void dfs(int row , int colm , char[][] grid) {
        if(row < 0 || colm < 0 || row >= grid.length || colm >= grid[0].length || grid[row][colm] == '0') return;
        grid[row][colm] = '0';
        dfs(row + 1,colm,grid);
        dfs(row - 1,colm,grid);
        dfs(row,colm+1,grid);
        dfs(row,colm-1,grid);
    }
}