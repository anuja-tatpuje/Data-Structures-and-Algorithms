class Solution {
    public int Bs(ArrayList<int[]> dp,int ele){
        int si = 0;
        int ei = dp.size()-1;
        
        while(si<=ei) {
            int mid =  (si+ei)/2;
            if(dp.get(mid)[1]<ele) {
                si = mid+1;
            } else {
                ei = mid -1;
            }
        }
        
        return si;
    }
    //o(n2)
    public int maxEnvelopesGTC(int[][] envelopes) {
         int n = envelopes.length;
        
        Arrays.sort(envelopes,(int[] a,int[] b)->{
           return a[0] - b[0]; //sort according weights;
        });
        
        int[] dp = new int[n];
        int ans = 0;
        
        for(int i=0;i<n;i++) {
            dp[i] = 1;
            
            int nWidth = envelopes[i][0];
            int nHeight = envelopes[i][1];
            
            for(int j=i-1;j>=0;j--) {
                 int oWidth = envelopes[j][0];
                 int oHeight = envelopes[j][1];
                
                if(oWidth < nWidth && oHeight < nHeight) {
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }
    public int maxEnvelopes(int[][] envelopes) {
        int ans = maxEnvelopesLogN(envelopes);
        return ans;
    }
    public int BS(ArrayList<Integer> dp ,int ele) {
        int si = 0;
        int ei = dp.size()-1;
        
        while(si<=ei) {
            int mid = (si+ei)/2;
            
            int dpEle = dp.get(mid);
            if(dpEle<ele) {
                si = mid + 1;
            } else {
                ei = mid - 1;
            }
        }
        
        return si;
    }
    public int maxEnvelopesLogN(int[][] envelopes) {
        int n = envelopes.length;
        
        Arrays.sort(envelopes,(int[] a,int[] b)->{
          if(a[0]==b[0]) return b[1]-a[1];
            return a[0] - b[0]; //sort according weights;
        });
        
         ArrayList<Integer> dp = new ArrayList<>();
        
        for(int[] a:envelopes) {
            int nweight = a[0];
            int nheight = a[1];
            
            int pos = BS(dp,nheight);
            
            if(pos == dp.size()) {
               dp.add(nheight);
            } else {
               dp.set(pos,nheight);
            }
        }
        return dp.size();
    }
}