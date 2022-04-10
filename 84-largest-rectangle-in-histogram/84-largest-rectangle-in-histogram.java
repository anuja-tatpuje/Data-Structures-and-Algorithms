class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        
        //finding next smaller element of left 
        int[] nsl = nextSmallerElementLeft(heights);
        //finding next smaller element on right
        int[] nsr = nextSmallerElementRight(heights);
        
        int area = 0;
        
        for(int i=0;i<n;i++) {
            int width = nsr[i] - nsl[i] - 1;
            int height = heights[i];
            
            int areaC = width * height;
            
            area = Math.max(area,areaC);
            
        }
        
        return area;
    }
    
    public int[] nextSmallerElementLeft(int[] a) {
        int n = a.length;
        
        int[] nsl = new int[n];
        
        Stack<Integer> st = new Stack<Integer>();
        nsl[0] = -1;
        st.push(0);
        
        for(int i=1;i<n;i++) {
            int ele = a[i];
            
            while(st.size()>0 && ele<=a[st.peek()]) {
                st.pop();
            }
            
            if(st.size() == 0) {
                nsl[i] = -1;
            } else {
                nsl[i] = st.peek();
            }
            
            st.push(i);
        }
        
        return nsl;
    }
    public int[] nextSmallerElementRight(int[] a) {
        int n = a.length;
        
        int[] nsr = new int[n];
        
        Stack<Integer> st = new Stack<Integer>();
        
        nsr[n-1] = n;
        
        st.push(n-1);
        
        for(int i=n-2;i>=0;i--) {
            int ele = a[i];
            
            while(st.size()>0 && ele <= a[st.peek()]) {
                st.pop();
            }
            
            if(st.size() == 0) {
                nsr[i] = n;
            } else {
                nsr[i] = st.peek();
            }
            
            st.push(i);
        }
        
        return nsr;
    }
}