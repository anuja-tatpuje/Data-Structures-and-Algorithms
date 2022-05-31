class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        
        for(int ast : asteroids) {
            
            if(ast>0) {
                st.push(ast);
            }
            else {
                while(st.size()>0 && st.peek()>0 && st.peek() < -ast) {
                    st.pop();
                } if(st.size()>0 && st.peek() == -ast) {
                    st.pop();
                } else if(st.size()>0 && st.peek() > -ast) {
                    continue;
                } else {
                    st.push(ast);
                }
            }
        }
        
        int[] finalArray = new int[st.size()];
        for(int i=st.size()-1;i>=0;i--) {
            finalArray[i] = st.pop();
        }
        
        return finalArray;
    }
}