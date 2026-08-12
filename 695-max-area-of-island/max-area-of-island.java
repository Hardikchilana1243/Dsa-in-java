class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int max = 0;
        for(int i=0;i<n;i++) {
            
            for(int j=0;j<m;j++){
               
                if(grid[i][j] == 1){ 
                    int count =0;
                   count = dfs(i,j,grid,count);
                    max = Math.max(max,count);
                }
                
            } 
           
        }
        return max;
    }
    public int dfs(int row ,int colm ,int[][] grid ,int count) {
        if(row < 0 || colm < 0 || row >= grid.length || colm >= grid[0].length || grid[row][colm] == 0)return 0;
        grid[row][colm] = 0;
        return 1+dfs(row+1,colm,grid,count) +dfs(row-1,colm,grid,count) + dfs(row,colm+1,grid,count) + dfs(row,colm-1,grid,count);

    }
}