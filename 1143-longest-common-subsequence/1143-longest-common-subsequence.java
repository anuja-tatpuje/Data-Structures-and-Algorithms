class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m= text2.length();
        int[][] dp = new int[n+1][m+1];
        int ans = longestCommonSubsequence_tab(n,text1,m,text2);
        return ans;
    }
    public int longestCommonSubsequence(int n,String text1,int m,String text2) {
        if(n== 0) {
            return 0;
        } 
        if(m==0) {
            return 0;
        }
        if(text1.charAt(n-1) == text2.charAt(m-1)) {
            return longestCommonSubsequence(n-1,text1,m-1,text2)+1;
        } else {
            return Math.max(longestCommonSubsequence(n,text1,m-1,text2),longestCommonSubsequence(n-1,text1,m,text2));
        }
    }
    public int longestCommonSubsequence_memoi(int n,String text1,int m,String text2,int[][] dp) {
        if(n== 0 || m==0) {
            return dp[n][m] = 0;
        } 
        if(dp[n][m] != 0) return dp[n][m];
        
        if(text1.charAt(n-1) == text2.charAt(m-1)) {
            return dp[n][m]= longestCommonSubsequence_memoi(n-1,text1,m-1,text2,dp)+1;
        } else {
            return dp[n][m]=Math.max(longestCommonSubsequence_memoi(n,text1,m-1,text2,dp),longestCommonSubsequence_memoi(n-1,text1,m,text2,dp));
        }
    }
    
    public int longestCommonSubsequence_tab(int n,String text1,int m,String text2) {
        int[][] dp = new int[n+1][m+1];
        
        for(int i=0;i<=n;i++) {
            for(int j=0;j<=m;j++) {
                if(i==0 || j==0) {
                    dp[i][j] = 0;
                } else if(text1.charAt(i-1)==text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1]+1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        
        return dp[n][m];
    }
}