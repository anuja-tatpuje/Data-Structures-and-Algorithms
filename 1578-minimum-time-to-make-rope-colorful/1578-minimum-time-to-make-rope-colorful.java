class Solution {
    public int minCost(String colors, int[] cost) {
        int max = 0, result = 0;
        
        for(int i=1;i<colors.length();i++) {
            if(colors.charAt(i) == colors.charAt(max)) {
                result += Math.min(cost[i],cost[max]);
                if(cost[i] > cost[max]) max = i;
            }
            else {
                 max = i;
            }    
        }
        
        return result;
    }
}