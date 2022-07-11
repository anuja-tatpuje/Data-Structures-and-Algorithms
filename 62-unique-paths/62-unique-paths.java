class Solution {
    public int uniquePaths(int m, int n) {
       /* int[][] dp = new int[m][n];
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                dp[i][j] = -1;
            }
        } */
        int paths = getPathsTabu(m,n);
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
    public static int getPathsTabu(int m,int n) {
        int[][] dp = new int[m][n];
        
        for(int i=m-1;i>=0;i--) {
            for(int j=n-1;j>=0;j--) {
                if(i==m-1 || j== n-1) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i+1][j] + dp[i][j+1];
                }
            }
        }
        
        return dp[0][0];
    }
}