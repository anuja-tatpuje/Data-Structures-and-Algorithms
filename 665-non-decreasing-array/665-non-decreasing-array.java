class Solution {
    public boolean checkPossibility(int[] nums) {
        int n = nums.length;
        int count = 0;
        for(int i=1;i<nums.length && count<=1;i++) {
            if(nums[i-1]>nums[i]) {
                if(count == 1) return false;
                
                if(i-2>=0 && nums[i-2]>nums[i] && i+1<n && nums[i-1]>nums[i+1]) return false;
                
                count++;
            }
        }
        
        return true;
    }
}