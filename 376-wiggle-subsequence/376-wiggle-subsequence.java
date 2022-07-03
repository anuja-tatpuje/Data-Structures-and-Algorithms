class Solution {
    public int wiggleMaxLength(int[] nums) {
        int maxWiggleSequence = 1;
         boolean isPositive = true;
         boolean isNegative = true;
        for(int i=0;i<nums.length-1;i++) {
            if(nums[i] < nums[i+1]) {
                if(isPositive) {
                    maxWiggleSequence += 1;
                }
                isPositive = false;
                isNegative = true;
            } else if(nums[i] > nums[i+1]) {
                if(isNegative) {
                    maxWiggleSequence += 1;
                }
                isNegative = false;
                isPositive = true;
            }
        }
        
        return maxWiggleSequence;
    }
}