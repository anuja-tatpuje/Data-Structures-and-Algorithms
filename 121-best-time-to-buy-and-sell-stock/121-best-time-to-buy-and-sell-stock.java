class Solution {
    public int maxProfit(int[] prices) {
        int dp0 = 0;
        int dp1 = -(int)(1e9);
        
        for(int i=0;i<prices.length;i++) {
            dp0 = Math.max(dp0,dp1+prices[i]);
            dp1 = Math.max(dp1,0-prices[i]);
        }
        
        return dp0;
    }
}