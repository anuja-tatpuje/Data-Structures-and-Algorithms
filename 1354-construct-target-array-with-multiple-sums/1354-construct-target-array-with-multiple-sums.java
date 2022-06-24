class Solution {
    public boolean isPossible(int[] target) {
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        long sum = 0;
        
        for(int num : target) {
            pq.add((long)num);
            sum += num;
        }
        
        while(pq.peek() != -1) {
            long top = pq.poll();
            long remTotal = sum - top;
            
            if(top == 1 || remTotal == 1) return true;
            
            if(remTotal == 0 || top<remTotal) return false;
            
            long updatedmax = top % remTotal;
            
            if(updatedmax == 0) return false;
            
            pq.add(updatedmax);
            sum = updatedmax + remTotal;
        }
        
        return true;
    }
}