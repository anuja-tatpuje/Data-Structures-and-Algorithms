class Solution {
    public boolean checkWeight(int[] weights,int mid,int days) {
        int tDays = 0;
        int currWeight = 0;
        for(int w : weights) {
   
            if(currWeight+w>mid) {
                tDays++;
                currWeight = w;
            } else {
                currWeight += w;
            }
            if(tDays>days) return false;
        }
        if(currWeight>0) tDays++;
        
        return tDays<=days;
    }
    
    public int shipWithinDays(int[] weights, int days) {
        int si = 0;
        int ei = 0;
        
        for(int weight : weights) {
            si = Math.max(si,weight);
            ei += weight;
        }
        while(si<=ei) {
            int mid = (si+ei)/2;
            
            if(checkWeight(weights,mid,days) == false) {
                si = mid + 1;   
            } else {
                ei = mid-1;
            }
        }
        
        return si;
     }
}