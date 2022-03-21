class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        
        LinkedList<Integer> que= new LinkedList<>();
        int[][] ans = new int[n][m];
        
        //filling array
        for(int[] e: ans) {
            Arrays.fill(e,-1);
        }
        
        for(int i = 0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(mat[i][j] == 0) {
                    que.addLast(i*m+j);
                } else {
                    ans[i][j] = -1;
                }
            }
        }
        
        int level = 0;
        
        while(que.size() > 0) {
            int size = que.size();
            
            while(size-->0) {
                int top = que.removeFirst();
                
                int row = top / m;
                int col = top % m;
                
                if(ans[row][col] != -1) continue;
                
                ans[row][col] = level;
                
                int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
                
                for(int[] dir : dirs) {
                    int x = row + dir[0];
                    int y = col + dir[1];
                    
                    if(x>=0 && y>=0 && x<n && y<m && ans[x][y] == -1) {  
                         que.addLast(x*m+y);
                        
                        
                    }
                }
            }
            level++;
        }
        
        return ans;
    }
}