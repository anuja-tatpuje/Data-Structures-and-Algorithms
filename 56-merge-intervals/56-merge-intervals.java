class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(int[] a,int[] b)->{
            return a[0] - b[0];
        });
        
        Stack<int[]> st = new Stack<>();
        int n = intervals[0].length;
        List<int[]> results = new ArrayList<>();
        
        st.push(intervals[0]);
        
        for(int i=1;i<intervals.length;i++) {
            int stp = intervals[i][0];
            int ep = intervals[i][1];
            
            //if starting point is lesser than ending point then we need to merge the intervals
            if(st.peek()[1] >= stp) {
                int[] ele = st.pop();
                
                int[] merge = new int[2];
                
                merge[0] = ele[0];
                merge[1] = Math.max(ele[1],ep);
                
                st.push(merge);
                
            } else {
             //we can consider it as another interval and push it to stack.  
                
                st.push(intervals[i]);
            }
        }
        
        Stack<int[]> temp = new Stack<>(); 
        while(st.size() > 0) {
            int[] ele = st.pop();
            temp.push(ele);
        }
        
        while(temp.size() > 0) {
            int[] ele = temp.pop();
            results.add(ele);
        }
        
         return results.toArray(new int[results.size()][]);
    }
}