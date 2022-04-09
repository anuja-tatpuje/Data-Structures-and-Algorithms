class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> getSkyline(int[][] buildings) {
        int n = buildings.length;
        
        // we are putting starting point and ending index;
        int[][] arr = new int[2*n][2];
        
        //creating array with sorted starting point
        // we are storing negative height in order to decide this is starting point
        
        int k=0;
        for(int i=0;i<n;i++) {
           int sp = buildings[i][0];
           int ep = buildings[i][1];
           int h = buildings[i][2];
            
           arr[k][0] = sp;
           arr[k][1] = -h;
            
           k++;
           
           arr[k][0] = ep;
           arr[k][1] = h;
             
           k++; 
        }

        Arrays.sort(arr,(int[] a,int[] b) -> {
            if(a[0] - b[0] == 0) {
                return a[1] - b[1];
            } else {
                return a[0] - b[0];
            }
        });
        
    
        int curr_h = 0;
        
        //to get maximum height from priority Queue.(max heap)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); 
        
        pq.add(0);
        
        for(int i=0;i<2*n;i++) {
            int x = arr[i][0];
            int h = arr[i][1];
            
            if(h<0) {
                pq.add((-1)*h);
            } else {
                pq.remove(h);
            }
            
            int topHeight = pq.peek();
                
            if(curr_h != topHeight) {
                List<Integer> ls = new LinkedList<>();
                ls.add(x);
                ls.add(topHeight);
                list.add(ls);
                curr_h = topHeight;
            }
        }
        
        return list;
    }
}