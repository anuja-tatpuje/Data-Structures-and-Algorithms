class Solution {
   class Edge{
    int src, nbr;

    Edge(int src, int nbr){
        this.src = src;
        this.nbr = nbr;
    }
}
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<Edge>[] graph = new ArrayList[n];
    
    // initialize graph with empty ArrayList of Edge
    for(int i = 0; i < n; i++) {
        graph[i] = new ArrayList<Edge>();
    }
    
    // mark graph
    for(int i = 0; i < edges.length; i++) {
        
        int v1 = edges[i][0];
        int v2 = edges[i][1];
        
        // bi-directional
        graph[v1].add(new Edge(v1, v2));
        graph[v2].add(new Edge(v2, v1));
    }
    
    boolean[] visited = new boolean[n];
    
    return hasPath(graph, source, destination, visited);
    }
    
    public boolean hasPath( ArrayList<Edge>[] graph, int source, int destination,boolean[] vis) {
        if(source == destination)
            return true;
        vis[source] = true;
        
        for(Edge edge : graph[source]) {
            int nbr = edge.nbr;
            if(vis[nbr] != true) {
                if(hasPath(graph,nbr,destination,vis)) return true;
            }
        }
        
        return false;
    }
}