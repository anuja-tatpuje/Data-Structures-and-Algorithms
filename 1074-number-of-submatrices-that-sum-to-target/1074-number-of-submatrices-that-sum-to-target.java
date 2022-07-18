class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int line = matrix.length;
        int column = matrix[0].length+1;
        int count = 0;
        int[][] sum = new int[line][column];
        
        for(int row=0;row<line;row++) {
            for(int col=1;col<column;col++) {
                sum[row][col] = sum[row][col-1] + matrix[row][col-1];
            }
        }
        
        for (int start = 0; start < column; start++){
            for (int end = start + 1; end < column; end++ ){
                
                int sumOfSubMatrix = 0;
                Map<Integer, Integer> map = new HashMap<Integer, Integer>();
                map.put(0, 1);
                for(int l = 0; l < line; l++){
                    sumOfSubMatrix += sum[l][end] - sum[l][start];
                    if (map.containsKey(sumOfSubMatrix - target))
                        count += map.get(sumOfSubMatrix - target);
                    map.put(sumOfSubMatrix, map.getOrDefault(sumOfSubMatrix, 0) + 1);
                    
                }
            }
        }
        
        return count;
    }
}