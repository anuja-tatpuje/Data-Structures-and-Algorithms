class Solution {
     int INT_MAX = 100000001;
    int[][][] dp;
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
         dp = new int[m][target+1][n+1];
       for(int i=0;i<m;i++){
            for(int j=0;j<target+1;j++){
                for(int k=0;k<n+1;k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        
        int res = minCost(houses,cost,m,n,target,0,0);
        return res == INT_MAX ? -1 : res;
    }
    public int minCost(int[] houses, int[][] cost, int m, int n, int tar,int i,int prev) {
        if(i == m) {
            if(tar == 0) return 0;
            
            return INT_MAX;
        }if(tar<0) {
            return INT_MAX;
        }
        if(dp[i][tar][prev] != -1) return dp[i][tar][prev];
        int ans = INT_MAX;
        if(houses[i] == 0) {
            
            for(int j=1;j<=n;j++) {
                ans = Math.min(ans, cost[i][j-1]+minCost(houses,cost,m,n,tar - (j != prev ? 1 : 0),i+1,j));
            }
            
            
        } else {
            ans =  minCost(houses,cost,m,n,tar - (houses[i] != prev ? 1 : 0),i+1,houses[i]);
        }
        
        return dp[i][tar][prev] = ans;
    }
}