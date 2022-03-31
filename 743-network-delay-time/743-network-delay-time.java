class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<int[]>[] graph = new ArrayList[n+1];
        
        for(int i=0;i<n;i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int[] edge : times) {
            int u = edge[0]-1;
            int v = edge[1]-1;
            int w = edge[2];
            
            graph[u].add(new int[]{v,w});
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] a,int[] b) ->{
           return a[1] - b[1]; 
        });
        
        int[] dis = new int[n];
        Arrays.fill(dis,(int)(1e8));
        
        dis[k-1] = 0;
        
        pq.add(new int[]{k-1,0});
        
        while(pq.size()>0) {
            int[] top = pq.remove();
            
            int node = top[0];
            int wsf = top[1];
            
            if(dis[node] < wsf) continue;
            
            for(int[] edge : graph[node]) {
                int wt = edge[1];
                int v = edge[0];
                
                if(dis[v] > wt+wsf) {
                    pq.add(new int[]{v,wt+wsf});
                    dis[v] = wt+wsf;
                }
            }
        }
        
        int max_time = 0;
        
        for(int i=0;i<n;i++) {
            if(dis[i] == 1e8) return -1;
            max_time = Math.max(max_time,dis[i]);
        }
        
        return max_time;
    }
}