class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String,Integer> map = new HashMap<>();
       
        int ans = 0;
        
        for(String word : words) {
            String rev = ""+word.charAt(1) + word.charAt(0);
            if(map.containsKey(rev)) {
                ans += 4;
                map.put(rev,map.get(rev)-1);
                if(map.get(rev) == 0) map.remove(rev);
                continue;
            }
            map.put(word,map.getOrDefault(word,0)+1);
        } 
        
        for(String word : map.keySet()) {
            if(map.get(word) == 1 && word.charAt(1) == word.charAt(0)) {
                ans += 2;
                break;
            }
        }
        
        System.out.println(ans);
        return ans;
    }
}