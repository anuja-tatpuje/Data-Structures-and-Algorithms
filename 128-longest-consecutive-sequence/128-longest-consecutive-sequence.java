class Solution {
    public int longestConsecutive(int[] nums,int n) {
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
    public int longestConsecutive(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int maxStreak = 0;
        
        for(int num : nums) {
           if(!map.containsKey(num)) {
                int left = map.containsKey(num-1) ? map.get(num-1) : 0;
                 int right = map.containsKey(num + 1) ? map.get(num+1) : 0;
            
                int sum = left + right + 1;
                map.put(num,sum);
            
                maxStreak = Math.max(sum,maxStreak);
            
                map.put(num-left,sum);
                map.put(num+right,sum);
           } else {
               continue;
           }
        }
        
        return maxStreak;
    }
}