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
    public void addEdge(ArrayList<Integer>[] ngraph,int u,int v) {
        ngraph[u].add(v);
        ngraph[v].add(u);
    }
    
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length+1;
        ArrayList<Integer>[] graph = new ArrayList[n];
        
        for(int i=0;i<n;i++) {
            graph[i] = new ArrayList<>();
        }
        
        par = new int[n];
        size = new int[n];
        
        for(int i=0;i<n;i++) {
            par[i] = i;
            size[i] = 1;
        }
        
         for(int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            
            int lu = findParent(u);
            int lv = findParent(v);
            
            if(lu != lv) {
                merge(lu,lv);
                addEdge(graph,lu,lv);
            } else {
                return edges[i];   
            }
        }
            
        return new int[] {-1, -1};
    }
}