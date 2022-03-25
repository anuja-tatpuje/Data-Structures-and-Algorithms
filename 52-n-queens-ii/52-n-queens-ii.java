class Solution {
    int count = 0;
    public int totalNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        solveNQueens(board,0);
        return count;
    }
    public boolean isMyQueenSafe(boolean[][] board,int row,int col) {
        int n = board.length;
        int[][] dirs = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
        for(int dist = 1;dist<n;dist++) {
            for(int[] dir : dirs) {
                int r =  dir[0];
                int c = dir[1];
                
                int nr = dist * r + row;
                int nc = dist * c + col;
                
                if(nr>=0 && nc>=0 && nr<n && nc<n) {
                    if(board[nr][nc] == true) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public void solveNQueens(boolean[][] board,int row) {
        if(row == board.length) {
            count++;
            return;
        }
        for(int col = 0;col<board.length;col++) {
            if(isMyQueenSafe(board,row,col) == true) {
                board[row][col] = true;
                solveNQueens(board,row+1);
                board[row][col] = false;
            }
        }
    }
}