class Solution {
    public int coinChange(int[] coins, int amount) {
        int ans = helper_Tab(coins,amount,coins.length);
        
        return ans == 1e9 ? -1 : ans;
    }
    public int helper_Tab(int[] coins,int amt,int n) {
        int[][] dp = new int[coins.length+1][amt+1];
        
        for(int i=0;i<=n;i++) {
            for(int j=0;j<=amt;j++) {
                if(i==0 ) {
                    dp[i][j] = (int) 1e9;
                    continue;
                } if(i>0 && j==0) {
                     dp[i][j] = 0;
                    continue;
                }
                if(coins[i-1]>j) {
                    dp[i][j] = dp[i-1][j];   
                } else {
                    dp[i][j] = Math.min((1 + dp[i][j - coins[i - 1]]),dp[i - 1][j]);
                }
            }
        }
        return dp[n][amt];
    }
    public int helper(int[] coins,int amt,int n,int[][] dp) {
       if(n==0 || amt == 0) {
           return dp[n][amt] = (amt == 0) ? 0 : (int) 1e9;
       }
       if(dp[n][amt] != -1) return dp[n][amt]; 
       if(coins[n-1]> amt) return helper(coins,amt,n-1,dp);
       else {
           return dp[n][amt]= Math.min(helper(coins,amt-coins[n-1],n,dp)+1,helper(coins,amt,n-1,dp));
       } 
    }
}