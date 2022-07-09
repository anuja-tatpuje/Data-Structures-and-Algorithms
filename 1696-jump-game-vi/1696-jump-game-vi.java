class Solution {
    public int maxResult(int[] nums,int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) ->(b[0] - a[0]));
        
        //putting max score in priority queue
        pq.add(new int[]{nums[0],0});
        
        int maxScore = nums[0];
        
        for(int i=1;i<nums.length;i++) {
            //checking if current index and max Score index is in window of K
            while(pq.peek()[1] < i-k) {
                pq.remove();
            }
            maxScore = pq.peek()[0]+nums[i];
            pq.add(new int[]{maxScore,i});
        }
        
        return maxScore;
    }
    public int maxResultWithMemoi(int[] nums, int k) {
        int[] mem = new int[nums.length]; // Lookup table to score max score for given node
        
        for(int i = 0; i < mem.length; i++) {
            mem[i] = Integer.MIN_VALUE;
        }
        return maxResult(nums,k,0,mem);
    }
    public int maxResult(int[] nums,int k,int index,int[] mem) {
        if(index >= nums.length-1) return nums[nums.length - 1];
        
        if(mem[index] != Integer.MIN_VALUE) return mem[index];
        
        int max = Integer.MIN_VALUE;
        
        for(int j=index+1;j<=Math.min(index+k,nums.length);j++) {
            max = Math.max(max,maxResult(nums,k,j,mem));
        }
    
        mem[index] = nums[index] + max;
        
        return mem[index];
    }
}