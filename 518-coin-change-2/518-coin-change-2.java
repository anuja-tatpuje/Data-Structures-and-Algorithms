class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int ans = changeCoinsTab(amount,coins);
        return ans;
    }
    public int changeRec(int amount, int[] coins,int idx,int n) {
        if(amount == 0) {
            return 1;
        }
        if(idx == n) {
            return 0;
        }
        int ans = 0;
        for(int j=idx;j<n;j++) {
            if(amount-coins[j]>=0) {
                ans += changeRec(amount-coins[j],coins,j,n);
            }
        }
        return ans;        
    }
    public int changeCoinsTab(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        
        dp[0] = 1;
        
        for(int coin : coins) {
            for(int j=coin;j<dp.length;j++) {
                dp[j] = dp[j] + dp[j-coin];
            }
        }
        
        return dp[amount];
    }
}