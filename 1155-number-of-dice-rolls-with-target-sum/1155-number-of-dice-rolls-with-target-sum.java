class Solution {
    int mod = (int) Math.pow(10, 9) + 7;
    public int numRollsToTarget(int d, int k, int target) {
          int[][] dp = new int[d + 1][target + 1];
        
        for(int[] ar : dp)
            Arrays.fill(ar, -1);
        
        return helper(d,k,target,dp);
        
    }
    public int helper(int d,int k,int target,int[][] dp) {
        if(d == 0 && target == 0) {
            return 1;
        }
        if(d == 0 || target < 0) return 0;
        
        if(dp[d][target] != -1) return dp[d][target];
        
        int count = 0;
        
        for(int face = 1; face <= k; face++) {
             count = (count+helper(d-1,k,target-face,dp))%mod;
        }
        
        dp[d][target] = count;
        return count;
    }
}