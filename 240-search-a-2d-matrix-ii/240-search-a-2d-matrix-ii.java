class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
    /*    for(int i=0;i<n;i++) {
            int indexFound = searchMatrix(matrix,i,0,m,target);
            if(indexFound != -1) {
                return true;
            }
        }
        
        return false; */
        
        int row = 0;
        int col = m-1;
        while(row<n && col>=0) {
            if(matrix[row][col] == target) {
                return true;
            } else if(matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        
        return false;
    }
    public int searchMatrix(int[][] matrix,int row,int si,int ei,int tar) {
        while(si<ei) {
            int midCol = (ei-si) / 2;
            if(matrix[row][midCol] == tar) {
                return midCol;
            }
            else if(matrix[row][midCol] >= tar) {
                ei = midCol;
            } else {
                si = midCol + 1;
            }
        }
        
        return -1;
    }
}