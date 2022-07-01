class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int maxUnits = 0;
        Arrays.sort(boxTypes,(x, y) -> y[1] - x[1]);
       
        for(int i=0;i<boxTypes.length;i++) {
            int boxes = boxTypes[i][0];
            int units = boxTypes[i][1];
            
            int remUnits = Math.min(boxes,truckSize);
            maxUnits += remUnits * units;
            truckSize -= remUnits;
            
            if(truckSize == 0) return maxUnits;
        }
        
        return maxUnits;
    }
}