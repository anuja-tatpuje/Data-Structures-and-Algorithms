class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        
        int[] lis = new int[n];
        
        for(int i=0;i<n;i++) {
            lis[i] = 1;
            for(int j=i-1;j>=0;j--) {
                if(nums[j]<nums[i]) {
                    lis[i] = Math.max(lis[i],lis[j]+1);
                }
            }
        }
        
        int[] lisd = new int[n];
        
        for(int i=n-1;i>=0;i--) {
            lisd[i] = 1;
            for(int j=i+1;j<n;j++) {
                if(nums[j]<nums[i]) {
                    lisd[i] = Math.max(lisd[i],lisd[j]+1);
                }
            }
        }
        
        int lisMountain = 0;
        for(int i=0;i<n;i++) {
            if(lis[i]>1 && lisd[i]>1)
            lisMountain = Math.max(lisMountain,lis[i]+lisd[i]-1);
        }
    
        return n-lisMountain;
    }
}