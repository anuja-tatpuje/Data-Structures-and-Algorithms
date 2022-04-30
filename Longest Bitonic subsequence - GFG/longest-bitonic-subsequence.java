// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();
            String[] s1 = s.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < s1.length; i++)
                nums[i] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int ans = ob.LongestBitonicSequence(nums);
            System.out.println(ans);           
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int LongestBitonicSequence(int[] nums)
    {
        int n = nums.length;
        int[] dplr = new int[n];
        int[] dprl = new int[n];
        for(int i=0;i<n;i++) {
            dplr[i] = 1;
            
            for(int j = i-1;j>=0;j--) {
                if(nums[j]<nums[i])
                dplr[i] = Math.max(dplr[i],dplr[j]+1);
            }
            
        }
        
        for(int i=n-1;i>=0;i--) {
            dprl[i] = 1;
            for(int j=i+1;j<n;j++) {
                if(nums[j]<nums[i])
                  dprl[i] = Math.max(dprl[i],dprl[j]+1);
            }
        }
        int lbs = 0;
        for(int i=0;i<n;i++) {
            lbs = Math.max(lbs,dplr[i]+dprl[i]-1);
        }
        
        return lbs;
    }
}