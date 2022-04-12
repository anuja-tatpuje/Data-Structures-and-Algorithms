class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int ans = jumpRec(n,nums,0,dp);
        return ans;
    }
    public int jumpRec(int n,int[] nums,int idx,int[] dp) {
        if(idx == n-1) {
            return dp[idx] = 0;
        }
        
        if(dp[idx] != 0) return dp[idx];
        int ans = (int)(1e8);
        int jumpsAllowed = nums[idx];
        
        for(int j=1;j<=jumpsAllowed && j+idx<n;j++) {
           ans = Math.min(ans,jumpRec(n,nums,j+idx,dp));
        }
        
        return dp[idx] = ans+1;
    }
}