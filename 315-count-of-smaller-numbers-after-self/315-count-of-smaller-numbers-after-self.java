class Solution {
    public List<Integer> countSmaller(int[] nums) {
        ArrayList<Integer> pos = new ArrayList<>();
        Integer[] ans = new Integer[nums.length];
        
        for(int i=nums.length-1;i>=0;i--) {
            int index = binarySearch(pos,nums[i]);
            
            ans[i] = index;
            pos.add(index,nums[i]);
        }
        return Arrays.asList(ans);
    }
    public int binarySearch(ArrayList<Integer> sorted,int target) {
        if(sorted.size() == 0) return 0;
        int left = 0;
        int right = sorted.size();
        
        while(left<right) {
            int mid = left + (right-left) /2;
            if(sorted.get(mid) >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
}