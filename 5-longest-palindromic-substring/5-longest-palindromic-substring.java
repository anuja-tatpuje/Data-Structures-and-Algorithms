class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int si = -1;
        int ei = -1;
        for(int diag=0;diag<n;diag++) {
            for(int i=0,j=diag;j<n;i++,j++) {
                if(diag==0) {
                    dp[i][j] = true;
                } else if(diag == 1) {
                    if(s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = true;
                    }
                } else {
                    if(s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                
                if(dp[i][j] == true) {
                    si = i;
                    ei = j;
                }
            }
        }    
        return s.substring(si,ei+1);
    }
}