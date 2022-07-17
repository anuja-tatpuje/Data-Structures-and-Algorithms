class Solution {
    private Integer[][] memo = new Integer[1001][1001];
    final int MOD = (int)(1e9+7);
    public int kInversePairs(int n, int k) {

        return find(n,k);
    }
    public int kInversePairsMemoi(int n, int k) {
        if(n == 0) return 0;
        if(k == 0) return 1;
        
        if(memo[n][k] != 0) return memo[n][k];
        
        int ans = 0;
        for(int i = 0;i <= Math.min(k,n-1); i++) {
            ans = (ans + kInversePairs(n - 1, k - i)) % 1000000007;
        }
        return memo[n][k] = ans%1000000007;
    }
    public int find(int n,int k) {
        
       int MOD = 1000000007;
        int[][] opt = new int[k + 1][n];
        
         for (int i = 0; i <= k; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    opt[i][j] = 1;
                } else if (j > 0) {
                    opt[i][j] = (opt[i - 1][j] + opt[i][j - 1]) % MOD;
                    if (i >= j + 1) {
                        opt[i][j] = (opt[i][j] - opt[i - j - 1][j - 1] + MOD) % MOD;
                    }
                }
            }
        }

        return opt[k][n-1];      
    }
}