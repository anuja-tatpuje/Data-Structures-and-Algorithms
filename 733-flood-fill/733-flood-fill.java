class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int n = image.length;
        int m = image[0].length;
        boolean[][] vis = new boolean[n][m];
        floodFillHelper(image,sr,sc,newColor,image[sr][sc],vis);
        return image;
        
    }
    
    public void floodFillHelper(int[][] image,int sr,int sc,int newColor,int oldColor,boolean[][] vis) {
        int n = image.length;
        int m = image[0].length;
        
        image[sr][sc] = newColor;
        
        vis[sr][sc] = true;
       
        
         int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
        
        for(int[] dir : dirs) {
            int x = sr + dir[0];
            int y = sc + dir[1];
            
            if(x>=0 && y>=0 && x<n && y<m && vis[x][y] == false && image[x][y] == oldColor) {
                floodFillHelper(image,x,y,newColor,oldColor,vis);
            }
        }
    }
}