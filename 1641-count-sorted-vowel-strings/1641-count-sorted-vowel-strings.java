class Solution {
    public int countVowelStrings(int n) {
        int ans = helper(5,n);
        return ans;
    }
    public int helper(int idx,int n) {
        if(idx == 0) return 0;
        if(n == 0 ) return 1;
        
        int res = helper(idx-1,n) + helper(idx,n-1);
        return res;
    }
}