class Solution {
    public int numIslands(char[][] grid) {
       int n = grid.length;
       int m = grid[0].length;
        
       int count = 0;
        
       for(int i=0;i<n;i++) {
           for(int j=0;j<m;j++) {
               if(grid[i][j] == '1') {
                 bfs(i,j,grid);
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
    
    public void bfs(int row,int col,char[][] grid) {
        int m = grid[0].length;
        int n = grid.length;
        LinkedList<Integer> que = new LinkedList<>();
        
        que.addLast(row*m+col);
         grid[row][col] = '0';
        
        while(que.size() > 0) {
            int top = que.removeFirst();
              
            int x = top / m;
            int y = top % m;
              
          int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
        
          for(int[] dir : dirs) {
             int r = x + dir[0];
             int c = y + dir[1];
             
             if(r>=0 && c>=0 && r < n  && c < m && grid[r][c] == '1') {
                que.addLast(r*m+c);
                grid[r][c] = '0';
             }
        }
    }
  } 
}