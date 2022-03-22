class Solution {
    ArrayList<Integer> al = new ArrayList<>();
    public boolean dfs(int src, ArrayList<Integer>[] courses,int[] vis) {
        vis[src] = 1;
        
        for(int nbr : courses[src]) {
            if(vis[nbr] == 0) {
                boolean cycle = dfs(nbr,courses,vis);
                if(cycle) return true;
            } else if(vis[nbr] ==1) {
                return true;
            }
        }
        
        vis[src] = 2;
        al.add(src);
        return false;      
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] vis = new int[numCourses];
        ArrayList<Integer>[] courses = new ArrayList[numCourses];
        
        for(int i=0;i<courses.length;i++) {
            courses[i] = new ArrayList<>();
        }
        
        //constructing graph
        for(int[] pre : prerequisites) {
            
            int a = pre[0];
            int b = pre[1];
            
            courses[b].add(a);
        }

        for(int i=0;i<courses.length;i++) {
            if(vis[i] == 0) {
                boolean cycle = dfs(i,courses,vis);
                if(cycle) {
                    return new int[]{};
                }
            } 
        }
        
        int j=0;
        int[] topo = new int[numCourses];
        
        for(int i= al.size()-1;i>=0;i--) {
            topo[j] = al.get(i);
            j++;
        }
        
        return topo;
        
    }
}