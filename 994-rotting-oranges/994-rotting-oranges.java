class Solution {
    public int orangesRotting(int[][] grid) {
        int freshOranges = 0;
        int n = grid.length;
        int m= grid[0].length;
        
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
            
        LinkedList<Integer> que = new LinkedList<>();
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j] == 1) {
                    freshOranges++;
                } else if(grid[i][j] == 2) {
                    //converting grid to 1D array for grid starting from 0 to n*m;
                    que.addLast(i*m+j);
                }
            }
        }
        
        if(freshOranges == 0)
            return 0;
        
        int level = 0;
        
        while(que.size() > 0) {
            int size = que.size();
            
            while(size-- > 0) {
                int top = que.removeFirst();
                
                int row = top / m;
                int col = top % m;
                
                //checking all directions for attacking the rotten oranges
                for(int dir[] : dirs) {
                    int x = row + dir[0];
                    int y = col + dir[1];
                    
                    //checking if calculated x & y goes beyond grid limits
                    if(x>=0 && y>=0 && x<n && y<m && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        freshOranges--;
                        
                        if(freshOranges == 0) {
                            return level+1;                            
                        }
                        
                        que.addLast(x*m+y);
                    }
                }
            }
            level++;    
        }
        
        return -1;
    }
}