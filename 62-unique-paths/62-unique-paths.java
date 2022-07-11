class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                dp[i][j] = -1;
            }
        }
        int paths = getPaths(0,0,m-1,n-1,dp);
        return paths;
    }
    public static int getPaths(int sr,int sc, int dr,int dc,int[][] dp) {
        if(sr>dr || sc>dc) {
            return 0;
        }
        if(sr == dr && sc == dc) {
            return 1;
        }
        if(dp[sr][sc] != -1) return dp[sr][sc];
        
        int horPaths = getPaths(sr,sc+1,dr,dc,dp);
        int verPaths = getPaths(sr+1,sc,dr,dc,dp);
        
        return dp[sr][sc] = horPaths+verPaths;
    }
}