class Solution {
    static class Edge {
      String src;
      String nbr;
     
      Edge(String src, String nbr) {
         this.src = src;
         this.nbr = nbr;
      }
    }
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
    public ArrayList<Edge>[] buildGraph(List<String> wordList,String beginWord) {
        int vtces = wordList.size()+1;
        ArrayList<Edge>[] graph = new ArrayList[vtces];
         wordList.add(0,beginWord);
        int length = wordList.size();
        
        for (int i = 0; i < vtces; i++) {
             graph[i] = new ArrayList<>();
        }
       
        for(int i=0;i<length;i++) {
            for(int j=i+1;j<length;j++) {
                String word1 = wordList.get(i);
                String word2 = wordList.get(j);
                if(isDifferenceOfOne(word1,word2)) {
                    graph[i].add(new Edge(word1,word2));
                    graph[j].add(new Edge(word2,word1));
                }
            }
        }
        
        return graph;
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
    public boolean isDifferenceOfOne(String word1,String word2) {
        int i = 0, j=0;
        int diffChars = 0;
        while(i<word1.length() && j<word2.length()) {
            char wc1 = word1.charAt(i);
            char wc2 = word2.charAt(j);
            
            if(wc1 != wc2) {
                diffChars+= 1;
            }
            i++;
            j++;
        }
        
        return diffChars == 1;
    }
    
   /* public void bring () {
        LinkedList<String> que = new LinkedList<>();
        que.addFirst(beginWord);
        
        
        while(que.size()>0) {
            int size = que.size();
                String currWord = que.removeFirst();
                
                char[] wordCharArray = currWord.toCharArray();
                for(int j=0;j<currWord.length();j++) {
                    char temp = currWord.charAt(j); 
                   for(char c = 'a';c<='z';c++) {
                     
                       if(wordCharArray[j] = c) continue;

                        wordCharArray[j] = c;
                       
                        String newWord = new String(wordCharArray);

                        if(words.contains(newWord)) {
                            
                            if(!visited.contains(newWord)) {
                                
                                visited.add(newWord);
                                que.addLast(newWord);
                                int nwIdx = wordList.indexOf(newWord);
                                int currIdx = wordList.indexOf(currWord);
                                currIdx = currIdx == -1 ? 0 : currIdx;
                                graph[nwIdx].add(new Edge(newWord,currWord));
                                graph[currIdx].add(new Edge(currWord,newWord));
                            
                            }
                        }

                        wordCharArray[j] = temp;
                    }
                    
                }
            level++;
        }

        return graph;
    }*/
    
}