class Solution {
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        int[] fArray = new int[n];
        fArray[0] = nums[0];
        int s = nums[0];
        for(int i=1;i<n;i++) {
            s += nums[i];
            fArray[i] = s;
        }
        
        return fArray;
    }
}