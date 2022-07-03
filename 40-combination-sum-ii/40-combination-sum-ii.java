class Solution {
    List<List<Integer>> fcsum = new ArrayList<>();
    List<Integer> csum = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(candidates,target,0);
        return fcsum;
    }
    public void helper(int[] arr, int target,int idx) {
        if(target == 0) {
            fcsum.add(new ArrayList<>(csum));
            return;
        }
        Set<Integer> set = new HashSet<>();
        for(int i=idx;i<arr.length;++i) {
            if(!set.contains(arr[i]) && target - arr[i] >= 0) {
                
                set.add(arr[i]);
                csum.add(arr[i]);
                helper(arr,target-arr[i],i+1);
                csum.remove(csum.size()-1);
                
            }
        }
    }
}