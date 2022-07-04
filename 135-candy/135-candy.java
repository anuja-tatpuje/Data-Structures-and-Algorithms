class Solution {
    public int candy(int[] ratings) {
        int prev = 1,totalCandy = 0;
        int[] candyArray = new int[ratings.length];
        
        Arrays.fill(candyArray,1);
        for(int i=1;i<ratings.length;i++) {
            if(ratings[i] > ratings[i-1]) {
                candyArray[i] = candyArray[i-1] + 1;
            } 
        }
        
        for(int i=ratings.length-2;i>=0;i--) {
            if(ratings[i] > ratings[i+1]) {
                candyArray[i] = Math.max(candyArray[i],candyArray[i+1] + 1);
            } 
        }
        
    
        for(int i=0;i<candyArray.length;i++) {
            totalCandy += candyArray[i];
        }
        
        return totalCandy;
    }
}