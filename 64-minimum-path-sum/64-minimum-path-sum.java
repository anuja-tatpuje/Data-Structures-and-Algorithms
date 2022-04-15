class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int[][] dp = new int[n][m];
        
        return recMinPathSumMemo(0,0,n,m,grid,dp);
        
    }
    public int recMinPathSum(int i,int j,int n,int m,int[][] grid) {
        if(i==n-1 && j==m-1) return grid[i][j];
        
        int ans = (int) 1e8;
        
        if(i+1<n) {
            ans = Math.min(ans,recMinPathSum(i+1,j,n,m,grid));
        } 
        if(j+1<m) {
            ans = Math.min(ans,recMinPathSum(i,j+1,n,m,grid));
        }
        
        return ans + grid[i][j];
    }
    public int recMinPathSumMemo(int i, int j,int n,int m,int[][] grid,int[][] dp) {
        if(i == n-1 && j==m-1)  {
            return dp[i][j] = grid[i][j];
        }
        
        if(dp[i][j] != 0) return dp[i][j];
        
        int ans = (int) 1e8;
        
        if(i+1<n) {
            ans = Math.min(ans,recMinPathSumMemo(i+1,j,n,m,grid,dp));
        }
        
        if(j+1<m) {
            ans = Math.min(ans,recMinPathSumMemo(i,j+1,n,m,grid,dp));
        }
        
        return dp[i][j] = ans + grid[i][j];
    }
}