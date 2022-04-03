class Solution {
    List<List<Integer>> perm = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        doPermute(nums,list);
        return perm;
    }
    
    public void doPermute(int[] nums,List<Integer> temp) {
         if(temp.size() == nums.length) {
            perm.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<nums.length;i++) {
            int num = nums[i];
            if(!temp.contains(num)) {
                temp.add(num);
                doPermute(nums, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
}