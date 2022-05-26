class Solution {
    int[][] dirs = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
    public char[][] updateBoard(char[][] board, int[] click) {
        int xc = click[0];
        int yc = click[1];
        
        if(board[xc][yc] == 'M') {
            board[xc][yc] = 'X';
            return board;
        }
        else {
            dfs(board,xc,yc);
            return board;
        }
    }
    public void dfs(char[][] board,int x,int y) {
         if(x>=board.length || x<0 || y>=board[0].length || y<0 || board[x][y]!='E')
            return;
        
        int minesNearMe = getMinesNearMe(board,x,y);
        if(minesNearMe > 0) {
            board[x][y] = (char) ('0' + minesNearMe);
        } else {
            board[x][y] = 'B';
            for(int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                
                dfs(board,nx,ny);
            }
        }
    }
    public int getMinesNearMe(char[][] board,int x,int y) {
        int count = 0;
        for(int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            
            if(nx>=0 && ny>=0 && nx<board.length && ny<board[0].length) {
                if(board[nx][ny] == 'M')
                    count += 1;
            }
        }    
        return count;
    }
}