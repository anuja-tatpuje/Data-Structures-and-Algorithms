class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        
        int[] incl = new int[n];
        int[] excl = new int[n];
        
        incl[0] = nums[0];
        excl[0] = 0;
        
        for(int i=1;i<n;i++) {
            incl[i] = excl[i-1]+nums[i];
            excl[i] = Math.max(incl[i-1],excl[i-1]);
        }
        
        return Math.max(incl[n-1],excl[n-1]);
    }
}