class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length())
       return false;
        Boolean[][] dp = new Boolean[s1.length()+1][s2.length()+1];
        return rec(s1,0,s2,0,s3,dp);
    }
    public boolean rec(String s1,int i, String s2,int j, String s3,Boolean[][] dp) {
        if(i == s1.length() && j == s2.length()) return true;
      
        if(dp[i][j] != null) return dp[i][j];
        
        if(i<s1.length() && s1.charAt(i) == s3.charAt(i+j)) {
            
            boolean f1 = rec(s1,i+1,s2,j,s3,dp);
            dp[i][j] = f1;
            if(f1 == true) {
                return true;
            }
            
        }  if(j<s2.length() && s2.charAt(j) == s3.charAt(i+j)) {
            boolean f1 = rec(s1,i,s2,j+1,s3,dp);
            dp[i][j] = f1;
            if(f1 == true) {
                return true;
            }
        } 
       return dp[i][j] = false;
    }
    
    public boolean isInterLeaveHelper(String s1,int itr1, String s2,int itr2, String s3,int itr3) {
        if(itr1 == s1.length()) return s2.substring(itr2).equals(s3.substring(itr3));
        if(itr2 == s2.length()) return s1.substring(itr1).equals(s3.substring(itr3));
        
        if(s1.charAt(itr1) == s3.charAt(itr3) && isInterLeaveHelper(s1,itr1+1,s2,itr2,s3,itr3+1) ||
          s2.charAt(itr2) == s3.charAt(itr3) && isInterLeaveHelper(s1,itr1,s2,itr2+1,s3,itr3+1))  {
            return true;
        } else {
            return false;
        }
    }
}