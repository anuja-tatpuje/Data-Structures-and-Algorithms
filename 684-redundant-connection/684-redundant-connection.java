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
    
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length+1;
        
        par = new int[n];
        size = new int[n];
        
        for(int i=0;i<n;i++) {
            par[i] = i;
            size[i] = 1;
        }
        
         for(int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];
            
            int lu = findParent(u);
            int lv = findParent(v);
            
            if(lu != lv) {
                merge(lu,lv); 
            }  else {
                //cycle exits
                return edge;   
            }
        }
            
        return new int[] {-1, -1};
    }
}