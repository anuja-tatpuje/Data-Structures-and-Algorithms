class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        int lcs = longestCommonSubsequence(s1,n,s2,m,dp);
        return lcs;
    }
    public int getSumOfLcs(String s,int idx) {
        int sum = 0;
        for(int i=0;i<idx;i++) {
            int x = s.charAt(i);
            sum += x;
        } 
        return sum;
    }
    public int longestCommonSubsequence(String s1,int n,String s2,int m,int[][] dp) {
        if(n==0) return dp[n][m] = getSumOfLcs(s2,m);
        if(m==0) return dp[n][m] = getSumOfLcs(s1,n);
        
        if(dp[n][m] != 0) return dp[n][m];
        
        if(s1.charAt(n-1) == s2.charAt(m-1)) {
            return dp[n][m] = longestCommonSubsequence(s1,n-1,s2,m-1,dp);
        } else {
            return dp[n][m] = Math.min(longestCommonSubsequence(s1,n-1,s2,m,dp) + s1.charAt(n-1), longestCommonSubsequence(s1,n,s2,m-1,dp)+s2.charAt(m-1));
        }
    }
}