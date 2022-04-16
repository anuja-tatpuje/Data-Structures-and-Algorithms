class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int ans = jumpMemoi(nums,n,0,dp);
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
}