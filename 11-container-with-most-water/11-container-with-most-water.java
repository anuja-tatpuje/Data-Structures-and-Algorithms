class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        
        int si = 0;
        int ei = height.length - 1;
        
        while(si<ei) {
            maxArea = Math.max(maxArea,Math.min(height[si],height[ei]) * (ei-si));
            
            if(height[si]<height[ei]) {
                si++;
            } else {
                ei--;
            }
        }
        return maxArea;
    }
}