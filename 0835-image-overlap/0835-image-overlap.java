class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int m = img1[0].length;
    
        List<int[]> limg1 = new ArrayList<>();
        List<int[]> limg2 = new ArrayList<>();
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(img1[i][j] == 1) limg1.add(new int[]{i,j});
                if(img2[i][j] == 1) limg2.add(new int[]{i,j});
            }
        }
     
         Map<String, Integer> map = new HashMap<>(); 
        
        for(int[] pt1 : limg1) {
            for(int[] pt2 : limg2) {
                String s = (pt1[0] - pt2[0]) + " " + (pt1[1]-pt2[1]); 
                map.put(s,map.getOrDefault(s,0)+1);
            }
        }
        
        int count = 0;
        for(int i : map.values()) {
            count = Math.max(count,i);
        }
       
        
        return count;
    }
}