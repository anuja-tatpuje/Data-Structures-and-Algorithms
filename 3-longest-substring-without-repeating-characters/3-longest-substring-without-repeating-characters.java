class Solution {
    public int lengthOfLongestSubstring(String s) {
        int si = 0;
        int ei = 0;
        
        //correct window --> {si,ei-1} 
        
        int[] freq = new int[128];
        int count = 0;
        int ans= 0;
        
        while(ei<s.length()) {
            char ch = s.charAt(ei);
            
            if(freq[ch] == 1) {
                count++;
            }
            
            freq[ch]++;
            ei++;
            
            while(count>0) { //correct the window
                if(freq[s.charAt(si)] == 2) {
                       count--;
                 }
                freq[s.charAt(si)]--;
                si++;
            }
            
            if(ans<(ei-si)) {
                ans = ei-si;
            }
        } 
        
        return ans;
    }
}