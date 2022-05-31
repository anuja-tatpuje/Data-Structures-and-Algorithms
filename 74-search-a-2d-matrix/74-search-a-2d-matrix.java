class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int ei = n*m-1;
        int si = 0;
        
        while(si<=ei) {
            int mid = (si+ei) / 2;
                                    
            int row = mid / m;
            int col = mid % m;
            
            if(matrix[row][col] == target) {
                return true;
            }  
            if(matrix[row][col] > target) {
                ei = mid-1;
            } else {
                si = mid + 1;
            }
        }
        
        return false;
    }
}