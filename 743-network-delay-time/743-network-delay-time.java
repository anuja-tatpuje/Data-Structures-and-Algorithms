class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<int[]>[] graph = new ArrayList[n+1];
        
        for(int i=0;i<n;i++) {
            graph[i] = new ArrayList<>();
        }
        
        
        for(int[] edge : times) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            int w = edge[2];
            
            graph[u].add(new int[]{v,w});
        }
        
        int[] dis = new int[n];
        Arrays.fill(dis,(int)(1e8));
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] a,int[] b)->{
           return a[1] - b[1]; 
        });
        
        dis[k-1] = 0;
        
        pq.add(new int[]{k-1,0});
        
        while(pq.size()>0) {
            int[] top = pq.remove();
        
            int v = top[0];
            int wsf = top[1];
            
            if(dis[v] < wsf) continue;
            
            for(int[] edge : graph[v]) {
                int nbr = edge[0];
                int wt = edge[1];
                
                if(dis[nbr] > wsf + wt) {
                    dis[nbr] = wsf + wt;
                    pq.add(new int[]{nbr,wsf+wt});
                }
            }
        }
        
        
        int maxTime = 0;
        for(int i=0;i<n;i++) {
            if(dis[i] == 1e8) return -1;
            maxTime = Math.max(maxTime,dis[i]);
        }
        
        return maxTime;
    }
}