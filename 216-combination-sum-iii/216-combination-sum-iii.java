class Solution {
   List<List<Integer>> fcsum = new ArrayList<>();
    List<Integer> csum = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        helper(1,n,k);
        return fcsum;
    }
    public void helper(int start,int n,int k) {
        if(n<0) return;
        if(n==0 && k==0) {
            fcsum.add(new ArrayList<>(csum));
            return;
        }
        for(int i=start;i<10;i++) {
            csum.add(i);
            helper(i+1,n-i,k-1);
            csum.remove(csum.size()-1);
        }
    }
}