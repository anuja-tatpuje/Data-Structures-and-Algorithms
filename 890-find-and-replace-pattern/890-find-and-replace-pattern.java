class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        String p = replacePattern(pattern);
        List<String> ans = new ArrayList<>();
        
        for(String word : words) {
            if(p.equals(replacePattern(word))) ans.add(word);
        }
        return ans;
    }
    public String replacePattern(String p) {
        HashMap<Character,Integer> map = new HashMap<>();
        
        String ans = "";
        
        for(int i=0;i<p.length();i++) {
            map.putIfAbsent(p.charAt(i),map.size());
            ans += map.get(p.charAt(i));
        }
        
        return ans;
    }
}