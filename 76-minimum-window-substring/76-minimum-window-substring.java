class Solution {
    public String minWindow(String s, String t) {
        int need = t.length();
        
        int[] req = new int[128];
        
        for(int i=0;i<t.length();i++) {
            req[t.charAt(i)]++; 
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
        
        return minLen == (1e9) ? "" : s.substring(gsi,gei);
    }
}