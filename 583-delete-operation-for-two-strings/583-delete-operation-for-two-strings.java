class Solution {
    public int minDistance(String word1, String word2) {
        int lw1 = word1.length();
        int lw2 = word2.length();
        int ans = longestCommonSubSequence(lw1,word1,lw2,word2);
        return lw1-ans + lw2-ans;
    }
    public int longestCommonSubSequence(int n,String word1,int m,String word2) {
        int[][] dp = new int[n+1][m+1];
        
        for(int i=0;i<=n;i++) {
            for(int j=0;j<=m;j++) {
                if(i==0 || j==0) {
                    dp[i][j] = 0;
                }
                else if(word1.charAt(i-1)==word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1]+1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        
        return dp[n][m];
    }
}