class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dps = new int[coins.length+1][amount+1];
        for(int[] dp : dps) {
            Arrays.fill(dp,-1);
        }
        int ans = helper(coins,amount,coins.length,dps);
        
        return ans == 1e9 ? -1 : ans;
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