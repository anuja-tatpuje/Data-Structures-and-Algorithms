class Solution {
    public boolean canJumpGreedy(int[] nums) {
       int n = nums.length;
        int maxJump = 0;
        for(int i=0;i<n;i++) {
            if(i > maxJump) {
                return false;
            }
            
            maxJump = Math.max(maxJump,i+nums[i]);
        }
        
        return true;
    }
    public boolean canJump(int[] nums) {
      int[] dp = new int[nums.length];
      Arrays.fill(dp, -1);
       return helper(0,nums,dp);
    }
    public boolean helper(int index,int[] nums,int[] dp) {
        if(index >= nums.length-1) {
            return true;
        }
        
        if(nums[index] == 0) {
            dp[index] = 0;
            return false;
        }
        
        if(dp[index] != -1) return dp[index] == 1;
        
        int jumpsAllowed = nums[index];
        for(int j=1;j<=jumpsAllowed;j++) {
            if(helper(index+j,nums,dp)) {
                dp[index] = 1;
                return true;
            }
        }
        dp[index] = 0;
        return false;
    }
   
}