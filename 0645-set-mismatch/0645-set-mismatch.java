class Solution {
    public int[] findErrorNums(int[] nums) {
        int repeatedNumber = 0;
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        long sum = (n*(n+1))/2;
        
        for(int i=0;i<nums.length;i++) {
            if(set.contains(nums[i])) {
                repeatedNumber = nums[i];
            }
            sum -= nums[i];
            set.add(nums[i]);
        }
           
        return new int[]{repeatedNumber,(int)sum+repeatedNumber};
        
        
    }
}