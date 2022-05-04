class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        
        for(int i=0;i<n;i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }
        
        Arrays.sort(jobs,(int[] a,int[] b)->{
           return a[1] - b[1]; 
        });
        
        ArrayList<int[]> etToProfit = new ArrayList<>();
        
        etToProfit.add(new int[]{0,0});
        
        for(int i=0;i<n;i++) {
            int[] job = jobs[i];
            
            int stTime = job[0];
            int eTime = job[1];
            int p = job[2];
            
            int j = -1;
            for(j=etToProfit.size()-1;j>=0;j--) {
                if(etToProfit.get(j)[0]<= stTime) {
                    break;
                }
            }
            
            int currProfit = etToProfit.get(j)[1]+p;
            
            if(etToProfit.get(etToProfit.size()-1)[1]<currProfit) {
                etToProfit.add(new int[]{eTime,currProfit});
            }
        }
        
        return etToProfit.get(etToProfit.size()-1)[1];
    }
}