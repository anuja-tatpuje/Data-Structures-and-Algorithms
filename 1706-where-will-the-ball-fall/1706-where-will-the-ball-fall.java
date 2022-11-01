class Solution {
    public int[] findBall(int[][] grid) {
        int balls = grid[0].length;
        int[] ans = new int[balls];
        for(int ball=0;ball<balls;ball++)
            ans[ball] = dfs(grid,0,ball);
            
        return ans;
    }
    
    public int dfs(int[][] grid,int i,int j) {
        if(i == grid.length) return j;
        
        if(j<0  || j>=grid[0].length) return -1;
        
        if(grid[i][j] == 1 && j+1<grid[0].length && grid[i][j+1] == 1) 
            return dfs(grid,i+1,j+1);
        else if(grid[i][j] == -1 && j-1 >=0 && grid[i][j-1] == -1)
            return dfs(grid,i+1,j-1);
        
        return -1;
    }
}