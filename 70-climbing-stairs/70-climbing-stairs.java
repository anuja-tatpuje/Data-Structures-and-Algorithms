class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        
        int ans = climbStairs(n,dp);
        return ans;
    }
    public int climbStairs(int n,int[] dp) {
        if(n == 0) return 1;
        
        if(dp[n] != 0) return dp[n];
        
        int ans = 0;
        ans += climbStairs(n-1,dp);
        
        if(n-2>=0) {
            ans += climbStairs(n-2,dp);
        }
        
        dp[n] = ans;
        
        return ans;
    }
}