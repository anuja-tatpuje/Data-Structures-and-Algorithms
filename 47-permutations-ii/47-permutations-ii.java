class Solution {
    List<List<Integer>> permuteU = new ArrayList<>();
    List<Integer> permute = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] vis = new boolean[nums.length];
        Arrays.sort(nums);
        helper(0,nums,vis);
        return permuteU;
    }
    public void helper(int idx,int[] nums,boolean[] vis) {
        if(idx==nums.length) {
            permuteU.add(new ArrayList<>(permute));
            return;
        }
        for(int i=0;i<nums.length;i++) {
            if(vis[i]) {
                continue;
            }
            
            if(i>0 && nums[i] == nums[i-1] && !vis[i-1]) continue;
            
            vis[i] = true;
            permute.add(nums[i]);
            helper(idx+1,nums,vis);
            permute.remove(permute.size()-1);
            vis[i] = false;
        }
    }
}