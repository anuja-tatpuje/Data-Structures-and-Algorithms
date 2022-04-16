class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int ans = jumpTab(nums,n);
        return ans;
    }
    public int jumpRec(int[] nums,int n,int idx) {
        if(idx==n-1) {
            return 0;    
        }
        
        int ans = (int) (1e8);
        int jumps_allowed = nums[idx];
        
        for(int j=1;j<=jumps_allowed && j+idx<n;j++) {
           ans = Math.min(ans,jumpRec(nums,n,j+idx));
        }
        
        return ans+1;
    }
    public int jumpMemoi(int[] nums,int n,int idx,int[] dp) {
        if(idx==n-1) {
            return dp[idx] = 0;   
        }
        
        if(dp[idx] != 0) return dp[idx];
        
        int ans = (int) (1e8);
        int jumps_allowed = nums[idx];
        
        for(int j=1;j<=jumps_allowed && j+idx<n;j++) {
           ans = Math.min(ans,jumpMemoi(nums,n,j+idx,dp));
        }
        
        return dp[idx] = ans+1;
    }
    
    public int jumpTab(int[] nums,int n) {
        int[] dp = new int[n+1];
        
        for(int idx=n-1;idx>=0;idx--) {
            if(idx==n-1) {
                dp[idx] = 0;
                continue;
            }
            if(dp[idx] != 0) {
                return dp[idx]; 
            }
            int ans = (int)(1e8);
            int jumps_Allowed = nums[idx];
            for(int j=1;j<=jumps_Allowed && j+idx<n;j++) {
                ans = Math.min(ans,dp[j+idx]);
            }
            
            dp[idx] = ans +1;
        }
        return dp[0];
    }
    
}