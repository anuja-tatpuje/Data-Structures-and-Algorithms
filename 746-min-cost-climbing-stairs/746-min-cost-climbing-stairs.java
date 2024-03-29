class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        return minCostClimbStairsDp(cost,n);
    }
    public int minCostClimbingStairs(int[] cost,int n,int ind) {
        if(ind>=n) return 0;
        else {
            return cost[ind] + Math.min(minCostClimbingStairs(cost,n,ind+1),minCostClimbingStairs(cost,n,ind+2));
        }
    }
    public int minCostClimbStairsDp(int[] cost,int n) {
        if(cost.length == 2) return Math.min(cost[0],cost[1]);
        
        int[] dp = new int[cost.length + 1]; // the one for the top
        dp[0] = 0; 
        dp[1] = 0; // we can reach index 0 or 1 freely
        
        for(int i=2;i<dp.length;i++) {
            dp[i] = Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        }
        
        return dp[dp.length-1];
    }
}