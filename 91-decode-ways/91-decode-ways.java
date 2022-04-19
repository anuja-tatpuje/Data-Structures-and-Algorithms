class Solution {
    int count;
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        Arrays.fill(dp,-1);
        return helperMemoi(s,0,dp);
    }
    public int helperMemoi(String s,int idx,int[] dp) {
        if(idx==s.length()) {
            return dp[idx] = 1;
            
        }   
        if(s.charAt(idx) == '0') {
            return 0;
        }
    
        if(dp[idx] != -1) return dp[idx];
         
        int ans = helperMemoi(s,idx+1,dp); 
       
        if(idx+2<=s.length()) {
            String sub = s.substring(idx,idx+2);
            
            int index = Integer.parseInt(sub);
            if(index<=26) {
              
                ans += helperMemoi(s,idx+2,dp);
            }
        }
        
        return dp[idx] = ans;
    }
    public int tabDecodeWays(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        int ans = 0;
        
        for(int idx=n;idx>=0;idx--) {
            if(idx==s.length()) {
                dp[idx] = 1;
                continue;
            }   
            if(s.charAt(idx) == '0') {
                   dp[idx] = 0;
                continue;
            }
          
            ans = dp[idx+1];

            if(idx+2<=s.length()) {
                String sub = s.substring(idx,idx+2);

                int index = Integer.parseInt(sub);
                if(index<=26) {
                        ans += dp[idx+2];
                }
            }

             dp[idx] = ans;
        }
        
        return dp[0];
    }
}