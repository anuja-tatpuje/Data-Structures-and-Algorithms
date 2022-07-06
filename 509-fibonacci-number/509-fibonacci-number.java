class Solution {
    public int fib(int n) {
        int[] dp = new int[n+1];
        return fib_Memoi(n,dp);
    }
    public int fib_Memoi(int n,int[] dp) {
        if(n<=1) return n;
        if(dp[n] != 0)  return dp[n];
        
        int ans = fib_Memoi(n-2,dp) + fib_Memoi(n-1,dp);
        
        dp[n] = ans;
        
        return ans;
    }
}