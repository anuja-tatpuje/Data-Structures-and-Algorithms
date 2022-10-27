class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        
        Arrays.sort(strs);
        
        int c = 0;
        StringBuilder sb = new StringBuilder();
        
        String first = strs[0];
        String last = strs[strs.length-1];
        
        while(c<first.length()) {
           if(first.charAt(c) == last.charAt(c)) {
               sb.append(first.charAt(c));
           } else {
               break;
           }   
            c++;
        }
        
        return c == 0 ? "" : sb.toString();
    }
}