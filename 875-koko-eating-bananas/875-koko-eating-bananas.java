class Solution {
    public boolean check(int[] piles,int h,int mid) {
        int totalCount = 0;
        for(int p : piles) {
            int time = p / mid;
            if(p % mid !=0) time++;
            totalCount += time;  
            
            if(totalCount>h) return false;
        }
        return totalCount<=h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        
        for(int i=0;i<piles.length;i++) {
            max = Math.max(max,piles[i]);
        }
                
        int ans = 0;
        int si = 1;
        int ei = max;
        while(si<=ei) {
            int mid = (si+ei)/2;
            
            if(check(piles,h,mid)) {
                ans = mid;
                ei = mid-1;
            } else {
                si = mid +1;
            }
        }
    
        return ans;
    }
}