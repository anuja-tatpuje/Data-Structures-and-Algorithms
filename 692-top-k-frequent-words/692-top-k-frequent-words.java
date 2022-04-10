class Solution {
    class node implements Comparable<node>{
        String data;
        int freq;
        
        public node(String data,int freq) {
            this.data = data;
            this.freq = freq;
        }
        
        public int compareTo(node other) {
           return this.freq == other.freq ? 
               this.data.compareTo(other.data) : 
               other.freq - this.freq;
        }
    }
    List<String> topkfwords = new ArrayList<>();
    
    public List<String> topKFrequent(String[] words, int k) {
         Map<String,Integer> map = new HashMap<>();
        for(String s : words) 
            map.put(s,map.getOrDefault(s,0)+1);
        
        PriorityQueue<node> pq = new PriorityQueue<>(k);
        
        for(Map.Entry<String,Integer> entry : map.entrySet()) {
            pq.add(new node(entry.getKey(),entry.getValue()));
        }
        
        for(int i=0;i<k;i++) {
            topkfwords.add(pq.remove().data);
        }
        
        return topkfwords;
    }
}