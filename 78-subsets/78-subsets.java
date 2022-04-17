class Solution {
    List<List<Integer>> subset = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        generateSubset(0,nums,n,list);
        return subset;
    }
    public void generateSubset(int idx,int[] nums,int n,List<Integer> list) {
        if(idx==n) {
            subset.add(new ArrayList<>(list));
            return;
        }
        //using element to create a subset;
        generateSubset(idx+1,nums,n,list); 
        //not using element to create a subset
        list.add(nums[idx]);
        generateSubset(idx+1,nums,n,list);
        list.remove(list.size()-1);
    }
}