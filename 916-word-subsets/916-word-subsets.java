class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> ans = new ArrayList<>();
        int[] count = new int[26],tmp;
        int i;
        for(String word : words2) {
            tmp = getCount(word);
            for(i=0;i<26;i++) {
                count[i] = Math.max(tmp[i],count[i]);
            }
        }
        
        for(String word : words1) {
            tmp = getCount(word);
            for(i=0;i<26;i++) {
               if(tmp[i] < count[i]) break;
            }
            if(i == 26) ans.add(word);
        }
        
        return ans;
    }
    public int[] getCount(String word) {
       int[] counter = new int[26];
        
        for(char c : word.toCharArray()) {
            counter[c-'a']++;
        }
        
        return counter;
    }
}