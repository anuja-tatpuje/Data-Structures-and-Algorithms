class Solution {
    class node implements Comparable<node>{
        int data;
        int freq;
        
        public node(int data,int freq) {
            this.data = data;
            this.freq = freq;
        }
        
        public int compareTo(node other) {
            return other.freq - this.freq ;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : nums) 
            map.put(i,map.getOrDefault(i,0)+1);
        
        
        PriorityQueue<node> pq = new PriorityQueue(k);
        
        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            pq.add(new node(entry.getKey(),entry.getValue()));
        }
       
        int[] ans = new int[k];
        
       for(int i=0;i<k;i++) {
            ans[i] =  pq.remove().data;;
        } 
        
        return ans;
    }
}