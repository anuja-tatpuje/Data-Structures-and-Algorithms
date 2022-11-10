class Solution {
    public int longestPalindrome(String[] words) {
      //  HashMap<String,Integer> map = new HashMap<>();
       
      /*  int ans = 0, unpaired = 0;
        
        for(String word : words) {
            if(word.charAt(1) == word.charAt(0)) {
                if(map.containsKey(word) && map.get(word) > 0) {
                    unpaired--;
                    map.put(word,map.get(word)-1);
                    ans += 4;
                } else {
                    unpaired++;
                    map.put(word,map.getOrDefault(word,0)+1);
                }
            } else {
                String rev = ""+word.charAt(1)+word.charAt(0);
                if(map.containsKey(rev) && map.get(rev) > 0) {
                    ans += 4;
                    map.put(word,map.get(rev)-1);
                } else {
                    map.put(word,map.getOrDefault(word,0)+1);
                }
            }
        }
        System.out.println(ans);
        if(unpaired>0) ans += 2; */
        
        HashMap<String, Integer> m = new HashMap();
    int unpaired = 0, ans = 0;
    for (String w: words) {
        if (!m.containsKey(w)) m.put(w, 0);
        if (w.charAt(0) == w.charAt(1)) {
            if (m.get(w) > 0) {
                unpaired--;
                m.put(w, m.get(w) - 1);
                ans += 4;
            }
            else {
                m.put(w, m.get(w) + 1);
                unpaired++;
            }
        }
        else {
            String rev = Character.toString(w.charAt(1)) + 
                Character.toString(w.charAt(0));
            if (m.containsKey(rev) && m.get(rev) > 0) {
                ans += 4;
                m.put(rev, m.get(rev) - 1);
            }
            else m.put(w, m.get(w) + 1);
        }

    }
    if (unpaired > 0) ans += 2;
        return ans;
    }
}