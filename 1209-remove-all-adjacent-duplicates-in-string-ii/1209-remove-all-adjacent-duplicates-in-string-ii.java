class Solution {
    class pair {
        char ch;
        int count;
        
        public pair(char ch) {
            this.ch = ch;
            this.count = 1;
        }
    }
    public String removeDuplicates(String s, int k) {
        Stack<pair> st = new Stack<>();
        
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            
            if(!st.empty() && st.peek().ch == c) {
                if(st.peek().count == k-1) {
                    st.pop();
                } else {
                   st.peek().count++;
                }
            } else {
                st.push(new pair(c));
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(pair p : st) {
            for(int i=0;i<p.count;i++) {
                 sb.append(p.ch);
            }     
        }
        
        return sb.toString();
    }
}