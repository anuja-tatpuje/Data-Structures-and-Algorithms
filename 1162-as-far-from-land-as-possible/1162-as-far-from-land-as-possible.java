class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        LinkedList<Integer> que = new LinkedList<>();
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j] == 1) {
                    que.addLast(i*m+j);
                }
            }
        }
        
        if(que.size() == n*m) return -1;
        if(que.size() == 0) return -1;
        
        int level = 0;
        while(que.size()>0) {
            int size = que.size();
            
            while(size-->0) {
                int top = que.removeFirst();
                
                int row = top / m;
                int col = top % m;
                    
                int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
                
                for(int[] dir : dirs) {
                    int x = row + dir[0];
                    int y = col + dir[1];
                    
                    if(x>=0 && y>=0 && x<n && y<n && grid[x][y] == 0) {
                        que.addLast(x*m+y);
                        grid[x][y] = 1;
                    }
                }
            }
            level++;
        }
        
        return level-1;
    }
}