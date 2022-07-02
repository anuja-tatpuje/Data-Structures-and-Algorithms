class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        long mod = (long) (1e9+7);
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        long maxHeight = Math.max(horizontalCuts[0]-0,h-horizontalCuts[horizontalCuts.length-1]);
       
        for(int i=1;i<horizontalCuts.length;i++) {
            long hrw = horizontalCuts[i] - horizontalCuts[i-1];
            maxHeight = Math.max(maxHeight,hrw);
        }
        
        long maxWidth = Math.max(verticalCuts[0]-0,w-verticalCuts[verticalCuts.length-1]);
        
        for(int i=1;i<verticalCuts.length;i++) {
            long vrt = verticalCuts[i] - verticalCuts[i-1];
            maxWidth = Math.max(maxWidth,vrt);
        }
 
         return (int)(maxHeight * 1L * maxWidth % 1_000_000_007);
    }
}