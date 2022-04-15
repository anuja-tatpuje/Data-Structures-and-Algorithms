class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int ans = jumpTab(n,nums);
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
    public int jumpTab(int n,int[] nums) {
        int[] dp = new int[n+1];
        
        for(int idx = n-1;idx>=0;idx--) {
            if(idx == n-1) {
                dp[idx] = 0;
                continue;
            }

            if(dp[idx] != 0) return dp[idx];
            int ans = (int)(1e8);
            int jumpsAllowed = nums[idx];

            for(int j=1;j<=jumpsAllowed && j+idx<n;j++) {
               ans = Math.min(ans,dp[j+idx]);
            }
            
            dp[idx] = ans+1;
        }
         return dp[0];
    }
}