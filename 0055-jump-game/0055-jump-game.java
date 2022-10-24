class Solution {
    public boolean canJump(int[] nums) {
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
   
}