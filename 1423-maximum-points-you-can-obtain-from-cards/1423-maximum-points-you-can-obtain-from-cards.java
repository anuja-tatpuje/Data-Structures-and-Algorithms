class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int maxSum = 0;
        int sum = 0;
        
        for(int i=0;i<k;i++) {
            sum += cardPoints[i];
        }
        
        maxSum = sum;
        int i=0;
        while(i<k) {
            sum -= cardPoints[k-i-1];
            sum += cardPoints[n-1-i];
            
            maxSum = Math.max(maxSum,sum);
            i++;
        }
        return maxSum;
    }
}