class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        int weak = 0;
        int length = properties.length;
        
        Arrays.sort(properties,(a,b) -> (b[0] == a[0]) ? (a[1] - b[1]) : b[0]-a[0]);
        
        int max = 0;
        for(int i=0;i<length;i++) {
            if(properties[i][1] < max) {
                weak++;
            }
            max = Math.max(max,properties[i][1]);
        }
        return weak;
    }
}