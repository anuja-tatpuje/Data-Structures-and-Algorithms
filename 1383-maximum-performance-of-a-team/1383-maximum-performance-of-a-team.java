class Solution {
    
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int MOD = (int) (1e9 + 7);
        
        int[][] eng = new int[n][2];
        
        for(int i=0;i<n;i++) {
            eng[i] = new int[]{efficiency[i],speed[i]};
        }
        
        Arrays.sort(eng,(a,b) -> b[0] - a[0]);
        
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        long teamSpeed = 0, teamPerformance = 0;
        
        for(int[] engineer : eng) {
            if(pq.size() >= k) {
                teamSpeed -= pq.remove();
            }
            
            pq.add(engineer[1]);
            teamSpeed += engineer[1];
            
            teamPerformance = Math.max(teamPerformance,teamSpeed * engineer[0]);
        }
        
        return (int) (teamPerformance % MOD);
    }
}