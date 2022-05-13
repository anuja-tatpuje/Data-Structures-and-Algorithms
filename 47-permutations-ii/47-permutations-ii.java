class Solution {
    List<List<Integer>> permuteU = new ArrayList<>();
    List<Integer> permute = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] vis = new boolean[nums.length];
        //Arrays.sort(nums);
        //helper(0,nums,vis);
        permute2(nums,0);
        return permuteU;
    }
    public void permute2(int[] nums,int l) {
        if(l==nums.length) {
            List<Integer> subList = new ArrayList<>();
            for(int num : nums) {
                subList.add(num);
            }
            permuteU.add(subList);
            return;
        }
        Set<Integer> set = new HashSet<>();
        for(int i=l;i<nums.length;i++) {
            if(!set.contains(nums[i])) {
                set.add(nums[i]);
                swap(nums,i,l);
                permute2(nums,l+1);
                swap(nums,i,l);
            }
        }
    }
    public void swap(int[] nums,int start,int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
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