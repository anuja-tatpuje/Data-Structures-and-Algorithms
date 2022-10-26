class Solution {
    int checkForSum = 0;
    public boolean checkSubarraySum(int[] nums, int k) {
       return helperCtSum(nums,k);
    }
    public boolean helperCtSum(int[] nums,int k) {
        HashSet<Integer> hashSet = new HashSet<>();
        int prev = 0, currSum = 0;
        for(int i=0;i<nums.length;i++) {
            currSum += nums[i];
            
            if(hashSet.contains(currSum % k)) {
                return true;
            }
            
            currSum %= k;
            hashSet.add(prev);
            prev = currSum;
            
        }
        
        return false;
    }
    public void helperTargetSum(int[] nums,int k,int index) {
        if(k == 0) return;
        if(index == nums.length-1) {
            return;
        }
        
        int sum = 0;
        int numbersAddedSoFar = 0;
        for(int i = index;i<nums.length;i++) {
            sum += nums[i];
            numbersAddedSoFar++;
            
            if(sum % k ==0) {
                if(numbersAddedSoFar >= 2) {
                    checkForSum++;                
                }
            }
        }
            helperTargetSum(nums,k,++index);
    }
}