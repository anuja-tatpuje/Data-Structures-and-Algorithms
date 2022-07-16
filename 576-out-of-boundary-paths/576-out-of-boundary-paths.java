class Solution {
    int[][] dirs={{0,1},{1,0},{0,-1},{-1,0}};
    int mod = 1000000007;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] dp = new int[51][51][52];
        
        for(int i=0;i<51;i++) {
            for(int j=0;j<51;j++) {
                for(int k=0;k<52;k++)
                    dp[i][j][k] = -1;
            }
        }
        
        return (int) dfs(m,n,maxMove,startRow,startColumn,dp) % mod;
    }
    public long dfs(int m, int n, int maxMove, int x, int y,int[][][] dp) {
        if(x<0 || y<0 || x>=m || y>=n) {
            return 1;
        }
        if(maxMove == 0) return 0;
        int ans = 0;
         if(dp[x][y][maxMove]!=-1)
            return dp[x][y][maxMove];
        
        for(int[] dir : dirs) {
           int nx = x + dir[0];
           int ny = y + dir[1];
           
           ans += dfs(m,n,maxMove-1,nx,ny,dp);
           ans %= mod;
       } 
        return dp[x][y][maxMove]=ans%mod;
    }
}