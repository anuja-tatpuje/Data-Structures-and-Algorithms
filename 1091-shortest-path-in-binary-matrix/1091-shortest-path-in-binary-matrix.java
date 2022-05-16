class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if(grid[0][0] != 0 || grid[n-1][m-1] != 0)
                return -1;
        LinkedList<int[]> que = new LinkedList<>();
        
        boolean[][] vis = new boolean[n][m];
        vis[0][0] = true;
        int ans = 1;
        
        int[][] dirs = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
        
        que.addFirst(new int[]{0,0});
        while(que.size() > 0) {
            int size = que.size();
            
            while(size-->0) {
                int[] top = que.removeFirst();
                
                int x = top[0];
                int y = top[1];
                
                if(x==n-1 && y==m-1) return ans;
                
                
                for(int[] dir : dirs) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    
                    if(nx>=0 && nx<n && ny>=0 && ny<m && grid[nx][ny] == 0 && !vis[nx][ny]) {
                        que.addLast(new int[]{nx,ny});
                        vis[nx][ny] = true;
                    }
                }
                
            }
            ans++;
        }
        
       return -1; 
    }
}