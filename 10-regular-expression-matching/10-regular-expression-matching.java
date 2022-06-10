class Solution {
    Boolean[][] dp;
    public boolean isMatch(String s, String p) {
        dp = new Boolean[s.length()+1][p.length()+1];
        return isAMatchInString(0,0,s,p); 
    }
    public boolean isAMatchInString(int i,int j,String s,String p) {
        if(j  == p.length()) return i == s.length();
        if(dp[i][j] != null) return dp[i][j];
        boolean firstCharMatch = i<s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        boolean ans = false;
        if(j+1 < p.length() && p.charAt(j+1) == '*') {
            
            ans = (firstCharMatch && isAMatchInString(i+1,j,s,p)) || isAMatchInString(i,j+2,s,p);
            
        }  else {
            
            ans = firstCharMatch && isAMatchInString(i+1,j+1,s,p);
        }
        
        return dp[i][j] = ans;
    }
}