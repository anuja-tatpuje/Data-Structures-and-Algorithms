class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        int ans = longestPalindromeSubseq(s,0,n-1,dp);
        return ans;
    }
    public int longestPalindromeSubseq(String s,int i,int j) {
        if(i==j) {
            return 1;
        }
        if(i>j) {
            return 0;
        }
        if(s.charAt(i) == s.charAt(j)) {
            return longestPalindromeSubseq(s,i+1,j-1) +2; 
        } else {
             return Math.max(longestPalindromeSubseq(s,i+1,j),longestPalindromeSubseq(s,i,j-1));
        }
    }
    public int longestPalindromeSubseq(String s,int i,int j,int[][] dp) {
        if(i==j) {
            return dp[i][j] = 1;
        }
        if(i>j) {
            return 0;
        }
        if(dp[i][j] != 0) return dp[i][j];
        
        if(s.charAt(i) == s.charAt(j)) {
            int onePal = longestPalindromeSubseq(s,i+1,j-1,dp) +2; 
            return dp[i][j] = onePal;
        } else {
             int oPal = Math.max(longestPalindromeSubseq(s,i+1,j,dp),longestPalindromeSubseq(s,i,j-1,dp));
            return dp[i][j] = oPal;
        }
    }
}