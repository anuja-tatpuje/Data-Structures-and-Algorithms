class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int[][] dis = new int[n][m];
        
        for(int i=0;i<n;i++) {
           for(int j=0;j<m;j++)
               dis[i][j] = (int) 1e8;
       }
        
       PriorityQueue<int[]> pq = new PriorityQueue<>((int[] a,int[] b)->{
            return a[2] - b[2];   
       });
        
        dis[0][0] = 0;
        pq.add(new int[]{0,0,0});
        
         int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
        
        while(pq.size()>0) {
            int[] top = pq.remove();
            
            int i = top[0];
            int j = top[1];
            int effort_so_far = top[2];
            
            if(dis[i][j] < effort_so_far) continue;
            
            if(i==n-1 && j == m-1) return dis[i][j];
            
            for(int[] dir : dirs) {
                int x = i + dir[0];
                int y = j + dir[1];
                
                if(x>=0 && y>=0 && x<n && y<m) {
                    int curr_eff = Math.max(grid[x][y],grid[i][j]);
                    int maxEffort = Math.max(curr_eff,effort_so_far);
                    
                    if(dis[x][y] > maxEffort){
                        dis[x][y] = maxEffort;
                        pq.add(new int[]{x,y,maxEffort});
                    }
                }
            }
        }
        return dis[n-1][m-1];
    }
}