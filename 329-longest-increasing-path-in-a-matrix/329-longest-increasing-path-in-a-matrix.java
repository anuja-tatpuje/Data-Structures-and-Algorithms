class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] ndegree = new int[n][m];
        
        int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                for(int[] dir : dirs) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    
                    if(x>=0 && y>=0 && x<n && y<m && matrix[x][y] > matrix[i][j]) {
                        ndegree[x][y]++;
                    }
                }        
            }
        }
        
        LinkedList<Integer> que = new LinkedList<>();
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(ndegree[i][j] == 0) {
                    que.addLast(i*m+j);
                }
            }
        }
        
        int level = 0;
        
        while(que.size() > 0) {
            int size = que.size();
            
            while(size-->0) {
                int top = que.removeFirst();
                
                int row = top /m;
                int col = top % m;
                
                for(int[] dir : dirs) {
                    int x = row + dir[0];
                    int y = col + dir[1];
                    
                    if(x>=0 && y>=0 && x<n && y<m && matrix[x][y] > matrix[row][col]) {
                        ndegree[x][y]--;
                        
                        if(ndegree[x][y] == 0) {
                            que.addLast(x*m+y);
                        }
                    }
            }
        }  
        level++;
}
        
        return level;
    }      
}    
    