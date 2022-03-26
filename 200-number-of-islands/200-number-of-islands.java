class Solution {
    public int numIslands(char[][] grid) {
       int n = grid.length;
       int m = grid[0].length;
        
       int count = 0;
        
       for(int i=0;i<n;i++) {
           for(int j=0;j<m;j++) {
               if(grid[i][j] == '1') {
                 dfs(i,j,grid);
                   count++;   
               }
           }
       }
        return count;
    }
    
    public void dfs(int i,int j,char[][] grid) {
         int n = grid.length;
         int m = grid[0].length;
         
         grid[i][j] = '0';
            
         int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
        
         for(int[] dir : dirs) {
             int row = i + dir[0];
             int col = j + dir[1];
             
             if(row>=0 && col>=0 && row < n  && col < m && grid[row][col] == '1') {
                 dfs(row,col,grid);
             }
         }
    }
}