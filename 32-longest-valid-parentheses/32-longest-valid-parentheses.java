class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int res = 0;
        st.push(-1);
        
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) == ')' && st.size()>1 && s.charAt(st.peek()) == '(') {
                st.pop();
                res = Math.max(res,i-st.peek());
            } else {
                st.push(i);
            }
        }
        return res;
    }
}