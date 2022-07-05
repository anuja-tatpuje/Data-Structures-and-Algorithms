class Solution {
    public int longestConsecutive(int[] nums) {
       HashSet<Integer> set = new HashSet<>();
        
        for(int num : nums) set.add(num);
        int longestConsecutive = 0;
        
        for(int num : nums) {
            if(!set.contains(num-1)) {
                int currentNum = num;
                int currentStreak = 1;
                
                
                while(set.contains(currentNum+1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }
                
                longestConsecutive = Math.max(currentStreak,longestConsecutive);
            }
        }
        
        return longestConsecutive;
    }
}