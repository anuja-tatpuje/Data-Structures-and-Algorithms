class Solution {
    public int minDistance(String word1, String word2) {
        int lw1 = word1.length();
        int lw2 = word2.length();
        int[][] dp = new int[lw1+1][lw2+1];
        int ans = minDistanceTab(lw1,word1,word2,lw2);
        return ans;
    }
    public int minDistanceRec(int n,String word1, String word2,int m) {
        if(n==0) return m;
        if(m==0) return n;
        
        if(word1.charAt(n-1) == word2.charAt(m-1)) {
            return minDistanceRec(n-1,word1,word2,m-1);
        }
        int ins = minDistanceRec(n,word1,word2,m-1)+1;
        int del = minDistanceRec(n-1,word1,word2,m)+1;
        int rep = minDistanceRec(n-1,word1,word2,m-1)+1;
        
        return Math.min(ins,Math.min(del,rep));
    }
    public int minDistanceMemoi(int n,String word1, String word2,int m,int[][] dp) {
        if(n==0) return dp[n][m] = m;
        if(m==0) return dp[n][m] = n;
        
        if(dp[n][m] != 0) return dp[n][m];
        
        if(word1.charAt(n-1) == word2.charAt(m-1)) {
            return dp[n][m] = minDistanceMemoi(n-1,word1,word2,m-1,dp);
        }
        int ins = minDistanceMemoi(n,word1,word2,m-1,dp)+1;
        int del = minDistanceMemoi(n-1,word1,word2,m,dp)+1;
        int rep = minDistanceMemoi(n-1,word1,word2,m-1,dp)+1;
        
        return dp[n][m] = Math.min(ins,Math.min(del,rep));
    }
    public int minDistanceTab(int N,String word1, String word2,int M) {
        int[][] dp = new int[N+1][M+1];
        
        for(int n=0;n<=N;n++) {
            for(int m=0;m<=M;m++) {
                if(n==0 || m==0) {
                    dp[n][m] = (n==0) ? m : n;
                    continue;
                }

                if(word1.charAt(n-1) == word2.charAt(m-1)) {
                   dp[n][m] = dp[n-1][m-1]; //,word1,word2,m-1,dp);
                    continue;
                }
                
                int ins = dp[n][m-1]+1;
                int del = dp[n-1][m]+1;
                int rep = dp[n-1][m-1]+1;

                dp[n][m] = Math.min(ins,Math.min(del,rep));
            }
        } 
        return dp[N][M];
    }
}