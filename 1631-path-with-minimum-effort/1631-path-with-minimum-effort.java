class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        
        int[][] dis = new int[n][m];
        
       for(int i=0;i<n;i++) {
           for(int j=0;j<m;j++)
               dis[i][j] = (int) 1e8;
       }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] a,int[] b)->{
            return a[2] - b[2];
        });
        
        pq.add(new int[]{0,0,0});
        dis[0][0] = 0;
        
        int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
        
        while(pq.size()>0) {
            int[] top = pq.remove();
            
            int i = top[0];
            int j = top[1];
            int curr_eff = top[2];
            
            if(dis[i][j] < curr_eff) continue;
            
            for(int[] dir : dirs) {
                int x = i + dir[0];
                int y = j + dir[1];
                
                if(x>=0 && y>=0 && x<n && y<m) {
                    int curr_effort = Math.abs(heights[i][j] - heights[x][y]);
                    
                    int maxEff = Math.max(curr_effort,curr_eff);
                    
                    if(dis[x][y] > maxEff) {
                         dis[x][y] = maxEff;
                    
                         pq.add(new int[]{x,y,maxEff});
                    }
                }
            }
            
        }
        
        return dis[n-1][m-1];
    }
}