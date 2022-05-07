class Solution {
    public boolean check(int[] q,int mid,int stores) {
        for(int qu: q) {
            int s = qu / mid;
            
            if(qu%mid != 0) s++;
            
            stores -= s;
            
            if(stores < 0) return false;
        }
        return stores >= 0;
    }
    public int minimizedMaximum(int n, int[] quantities) {
        int si = 1;
        int ei = 0;
        
        for(int i=0;i<quantities.length;i++) {
            ei = Math.max(ei,quantities[i]);
        
        }
    
        while(si<=ei) {
            int mid = (si+ei)/2;
            
            if(check(quantities,mid,n)==false) {
                si = mid + 1;
            } else {
                ei = mid - 1;
            }
        }
        
        return si;
    }
}