class Solution {
    List<List<Integer>> fcsum = new ArrayList<>();
    List<Integer> csum = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        helper(candidates,target,0);
        return fcsum;
    }
    public void helper(int[] candidates, int target,int idx) {
        if(idx==candidates.length) {
            if(target == 0) {
                fcsum.add(new ArrayList<>(csum));
            }
            return;
        }
        if(candidates[idx]<= target) {
             csum.add(candidates[idx]);
             helper(candidates,target-candidates[idx],idx);
             csum.remove(csum.size()-1);
        }
        helper(candidates,target,idx+1);
    }
}