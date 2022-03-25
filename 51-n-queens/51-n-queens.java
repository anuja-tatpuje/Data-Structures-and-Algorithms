class Solution {
    List<List<String>> queen = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        boolean[][] queens = new boolean[n][n];
        solveNQueens(queens,0);
        return queen;
    }
    
    public boolean isMyQueenSafe(boolean[][] queens,int row,int col) {
        int n = queens.length;
        int[][] dirs = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
        for(int dist=1;dist<=n;dist++) {
            for(int[] dir : dirs) {
                int rm = dir[0];
                int cm = dir[1];
                int nr = row + (dist*rm);
                int nc = col + (dist*cm);
                
                if(nr>=0 && nc>=0 && nr<n && nc<n) {
                    if(queens[nr][nc] == true) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    public void solveNQueens(boolean[][] queens,int row) {
        if(row == queens.length) {
            queen.add(getBoard(queens));
            return;
        }   
        for(int col=0;col<queens.length;col++) {
            if(isMyQueenSafe(queens,row,col) == true) {
                queens[row][col] = true;
                solveNQueens(queens,row+1);
                queens[row][col] = false;
            }
        }
    
    }
    
    public List<String> getBoard(boolean[][] queens) {
        List<String> board = new ArrayList<String>();
        
        for(int i=0;i<queens.length;i++) {
            StringBuilder str = new StringBuilder();
            for(int j=0;j < queens[0].length;j++) {
                if(queens[i][j] == true) {
                    str.append('Q');
                }  else {
                    str.append('.');
                }
            }
            board.add(str.toString());
        }
        
        return board;
    }
}