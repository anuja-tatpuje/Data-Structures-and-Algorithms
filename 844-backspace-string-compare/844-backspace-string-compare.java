class Solution {
    public boolean backspaceCompare(String s, String t) {
        String s1 = processString(s);
        String t1 = processString(t);
        return s1.equals(t1);
    }
    public String processString(String str) {
        Stack<Character> st = new Stack<>();
        
        for(int i=0;i<str.length();i++) {
            char ch = str.charAt(i);
            if(ch == '#') {
               if(!st.empty()) st.pop(); 
            } else {
                st.push(ch);
            }
        }
        String processed = "";
        while(!st.empty()) {
            processed += st.pop();
        }
        
        return processed;
    }
}