class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                pq.add(matrix[i][j]);
                if(pq.size() > k) {
                    pq.remove();
                }
            }
        }
        
        return pq.remove();
    }
}