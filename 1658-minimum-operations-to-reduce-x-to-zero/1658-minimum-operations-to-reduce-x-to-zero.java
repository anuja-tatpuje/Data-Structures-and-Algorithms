class Solution {
    public int minOperations(int[] nums, int x) {
        int i= 0,j = 0;
        int n = nums.length,sum = 0;
        int maxLen = 0, target = 0;
        int currSum = 0;
        for(int num : nums) {
            sum += num;
        }
        
        target = sum - x;
        boolean found = false;
        while(j<n) {
            currSum += nums[j];
        
            if(currSum>target) {
                while(i<=j && currSum>target) {
                    currSum -= nums[i];
                    i++;
                }
            }
            if(currSum == target) {
                maxLen = Math.max(maxLen,j-i+1);
                found = true;
            }
            j++;
        }
        
        return found == true ? n - maxLen : -1;
    }
}