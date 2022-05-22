class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1 ||obstacleGrid[n-1][m-1] == 1) return 0;
        int[][] dp = new int[n][m];
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                dp[i][j] = -1;
            }
        }
        
        return uniquePathsWithObstaclesMemo(obstacleGrid,0,0,n,m,dp);
    }
    public int uniquePathsWithObstaclesRec(int[][] arr,int row,int col,int m,int n) {
        if(row==n-1 && col==m-1) return 1;
        if(row<0 || row>n || col<0 || col>m || arr[row][col]==1) return 0;
        
        return
            uniquePathsWithObstaclesRec(arr,row+1,col,m,n) +
            uniquePathsWithObstaclesRec(arr,row,col+1,m,n);
    }
    public int uniquePathsWithObstaclesMemo(int[][] arr,int row,int col,int n,int m, int[][] dp) {
        if(row >= n|| col >= m || arr[row][col]==1) 
            return 0;
    
        if(row == arr.length-1 && col==arr[0].length-1) return 1;
        
        if(dp[row][col] != -1) return dp[row][col];
        
        return dp[row][col] = uniquePathsWithObstaclesMemo(arr,row+1,col,n,m,dp) + uniquePathsWithObstaclesMemo(arr,row,col+1,n,m,dp);
        
    }

}