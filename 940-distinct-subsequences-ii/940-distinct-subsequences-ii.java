class Solution {
    public int distinctSubseqII(String s) {
        int[] loc = new int[26];
        Arrays.fill(loc,-1);
        
        int n = s.length();
        
        long[] dp = new long[n+1];
        
        dp[0] = 1;
        long mod = (long)(1e9+7);
        
        for(int i=1;i<=n;i++) {
            dp[i] = (2 * dp[i-1]); 
            
            char ch = s.charAt(i-1);
            
            int lastIndex = loc[ch-'a'];
            //substracting numbers earlier to that index so that we can avoid duplicates
            if(lastIndex != -1){
                dp[i] = ((dp[i]%mod)-(dp[lastIndex-1]%mod)+mod) % mod;
            }
            
            loc[ch - 'a'] = i;
            dp[i] = dp[i] % mod;
        }
        
        return (int) dp[n]-1;
    }
}