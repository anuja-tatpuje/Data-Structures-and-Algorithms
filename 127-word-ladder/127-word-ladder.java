class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord))
            return 0;
        
        Set<String> words = new HashSet<>();
        for(String word : wordList) {
            words.add(word);
        }
        
        int level = 1;
        LinkedList<String> que = new LinkedList<>();
        que.addFirst(beginWord);
        
        
        while(que.size()>0) {
            int size = que.size();
            for(int i=0;i<size;i++) {
                String currWord = que.removeFirst();
                
                char[] wordCharArray = currWord.toCharArray();
                
                for(int j=0;j<currWord.length();j++) {
                    char temp = currWord.charAt(j); 
                   for(char c = 'a';c<='z';c++) {
                     wordCharArray[j] = c;

                        String newWord = new String(wordCharArray);

                        if(words.contains(newWord)) {
                            if(newWord.equals(endWord)) return level+1;
                            que.addLast(newWord);
                            words.remove(newWord);
                        }

                        wordCharArray[j] = temp;
                    }
                    
                }
            }
            level++;
        }
        
        return 0;
    }
}