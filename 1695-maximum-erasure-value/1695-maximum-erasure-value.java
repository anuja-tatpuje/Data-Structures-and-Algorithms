class Solution {
    public int maximumUniqueSubarray(int[] nums) {
       Set<Integer> uniq = new HashSet<>();
        int l=0, r= 0;
        int n = nums.length;
        int sum = 0;
        int max = 0;
        while(r<n) {
            while(!uniq.add(nums[r])) {
                sum -= nums[l];
                uniq.remove(nums[l++]);
            }
            sum += nums[r];
            max = Math.max(max,sum);
            r++;
        }
        return max;
    }
}