class Solution {
    List<List<String>> ladders = new ArrayList<>();
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return ladders;
        
        Set<String> words = new HashSet<>();
        words.addAll(wordList);
        words.add(beginWord);
        
        Map<String, Integer> level = new HashMap<>();
        Map<String, Set<String>> map = new HashMap<>();
        Set<String> visited = new HashSet<>();
        List<String> temp = new ArrayList<>();
        
        buildGraph(endWord, level, map, words);
        
        visited.add(beginWord);
        temp.add(beginWord);
        
       
       dfs(beginWord, endWord, level, map,temp, visited);
        
        return ladders;
    }
    public void dfs(String beginWord, String endWord, Map<String, Integer> level, Map<String, Set<String>> map,List<String> temp, Set<String> visited) {
        if(beginWord.equals(endWord)) {
            ladders.add(new ArrayList<>(temp));
            return;
        }
        for(String candidate : map.get(beginWord)) {
            if(level.get(candidate) + 1 == level.get(beginWord) && !visited.contains(candidate)) {
                visited.add(candidate);
                temp.add(candidate);
                dfs(candidate,endWord,level,map,temp,visited);
                visited.remove(candidate);
                temp.remove(temp.size()-1);
            }
        }
    }
    public void buildGraph(String beginWord, Map<String, Integer> level, Map<String, Set<String>> map, Set<String> words) {
        LinkedList<String> que = new LinkedList<>();
        
        for(String word : words) {
             map.put(word,new HashSet<>());
        }
        
        que.addFirst(beginWord);
        level.put(beginWord,0);
        
        while(que.size()>0) {
            String w = que.removeFirst();
            
            for(String candidate : transform(w, words)){
                map.get(candidate).add(w);
                if(!level.containsKey(candidate)){
                    level.put(candidate, level.get(w) + 1);
                    que.addLast(candidate);
                }
            }
        }
        
    }
    public List<String> transform(String beginWord, Set<String> words) {
        List<String> candidates = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        sb.append(beginWord);
        
        for(int i=0;i<beginWord.length();i++) {
            char temp = beginWord.charAt(i); 
            for(char c = 'a';c<='z';c++) {
              if(beginWord.charAt(i) != c){
                    sb.setCharAt(i, c);
                      if(words.contains(sb.toString())){
                         candidates.add(sb.toString());
                       }
                 }
             }
             sb.setCharAt(i, beginWord.charAt(i));
        }
         return candidates;
    }
}