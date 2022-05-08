// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String str = br.readLine();
            
            Solution obj = new Solution();
            System.out.println(obj.findSubString(str));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public int findSubString( String s) {
        int need = 0;
        int[] req = new int[128];
        
        for(int i=0;i<s.length();i++) {
            if(req[s.charAt(i)]==0) {
                need++;
                req[s.charAt(i)]=1;
            }
        }
        
        
        int si = 0;
        int ei = 0;
        int gsi = 0;
        int gei = 0;
        int minLen = (int)(1e9);
        
        while(ei<s.length()) {
            if(req[s.charAt(ei)] > 0) {
                need--;
            }
            
            req[s.charAt(ei)]--;
            ei++;
            
            while(need == 0) {
                if(minLen>(ei-si)) {
                    minLen = ei-si;
                    gsi = si;
                    gei = ei;
                }
                
                if(req[s.charAt(si)]==0) {
                    need++;
                }
                
                req[s.charAt(si)]++;
                si++;
            }
        }
        
        return minLen;
    }
}