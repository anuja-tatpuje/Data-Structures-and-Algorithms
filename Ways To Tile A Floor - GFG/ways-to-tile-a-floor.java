// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.numberOfWays(N));
        }
    }
}// } Driver Code Ends


class Solution {
    static long mod = (long) (1e9+7);
    static long rec(int n,long[] dp) {
        if(n==0)
            return 1;
        
        long ans = 0;
        if(dp[n]!=0) return dp[n];
                
        ans = rec(n-1,dp);
        
        if(n-2>=0) {
            ans += rec(n-2,dp);
        }
        
        return dp[n]=ans % mod;
    }
    static Long numberOfWays(int N) {
        long[] dp = new long[N+1];
        long ans = rec(N,dp);
        return ans;
    }
};