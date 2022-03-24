class Solution {
    int[] par;
    int[] size;
    public int findParent(int u) {
        if(par[u] == u) 
            return u;
        
        int p = findParent(par[u]);
        
        par[u] = p;
        
        return p;
    }
    
    public void merge(int p1,int p2) {
        if(size[p1] >= size[p2]) {
            par[p2] = p1;
            size[p1] += size[p2];
        } else {
            par[p1] = p2;
            size[p2] += size[p1];
        }
    }
    
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n - 1) {
            // impossible to connect all n vertices/computers
            return -1;
        }
          
        par = new int[n];
        size = new int[n];
        
        //initializing parent array
        for(int i=0;i<n;i++) {
            par[i] = i;
            size[i] = 1;
        }
    
        int numberOfConnections = n;
        
        for(int[] edge : connections) {
            int u = edge[0];
            int v = edge[1];
            
            int lu = findParent(u);
            int lv = findParent(v);
            
            if(lu != lv) {
                numberOfConnections--;
                merge(lu,lv);
            } 
        }
        
/*        //to connect n components we need n-1 edges
        //counting different components represents to different leaders
        for(int i=0;i<par.length;i++) {
            if(par[i] == i)
                numberOfConnections++;
        } 
        */
        
       return numberOfConnections-1;
    }
}