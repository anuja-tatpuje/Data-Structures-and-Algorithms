class Solution {
     List<List<Integer>> paths;
	 List<Integer> path;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        paths = new ArrayList<>();
	 	path = new ArrayList<>();
        int n = graph.length;
        boolean[] vis = new boolean[n];
        path.add(0);
        allPathsFromSourceTarget(0,graph.length-1,vis,graph);
        return paths;
    }
    public void allPathsFromSourceTarget(int src,int dest,boolean[] vis,int[][] graph) {
        if(src == dest) {
            paths.add(new ArrayList<>(path));
            return;
        }
        vis[src] = true;
        
        
        for(int nbr : graph[src]) {
            if(!vis[nbr]) {
                path.add(nbr);
                
                allPathsFromSourceTarget(nbr,dest,vis,graph);
                 
                //removing prior paths which are added to arraylist
                path.remove(path.size()-1);
            }
        }
        vis[src] = false;
    }
}