class Solution {
    public int minimumLengthEncoding(String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));
        
        List<String> wordList = new ArrayList<>(set);
        
        List<String> dupList = new ArrayList<>();
        
        for(int i=0;i<wordList.size();i++) {
            for(int j=0;j<wordList.size();j++) {
                if(i!=j) {
                    if(wordList.get(i).endsWith(wordList.get(j))) {
                        dupList.add(wordList.get(j));
                    }
                }
            }
        }

        int count = 0;
        for(String word : wordList) {
            if(!dupList.contains(word)) {
               count += word.length()+1; 
            }
        }
        return count;
    }
}