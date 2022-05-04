class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        int rl = rides.length;
        
        Arrays.sort(rides,(int[] a,int[] b)->{
           return a[1] - b[1]; 
        });
        
        ArrayList<long[]> etToProfit = new ArrayList<>();
        
        etToProfit.add(new long[]{0,0,0});
        
        for(int i=0;i<rl;i++) {
            int st = rides[i][0];
            int et = rides[i][1];
            int pf = rides[i][2];
            
            int j = -1;
            for(j=etToProfit.size()-1;j>=0;j--) {
                if(etToProfit.get(j)[1]<=st) {
                    break;
                }
            }
            
            long prevProfit = etToProfit.get(j)[2];
            long currProfit = prevProfit + ((et-st)+pf);
            
            if(currProfit > etToProfit.get(etToProfit.size()-1)[2]) {
                etToProfit.add(new long[]{st,et,currProfit});
            }
        }
        
        return etToProfit.get(etToProfit.size()-1)[2];
    }
}