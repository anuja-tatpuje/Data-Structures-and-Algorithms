class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> bankSet = new HashSet<>();
        
        List<Character> alphabetlist = new ArrayList<>();
        
        alphabetlist.add('A');
        alphabetlist.add('C');
        alphabetlist.add('G');
        alphabetlist.add('T');
        
        
        for(String word : bank) {
            bankSet.add(word);
        }
        
        if(!bankSet.contains(end)) return -1;
        
        LinkedList<String> que = new LinkedList<>();
        que.addLast(start);
        
        int mutation = 0;
        
        while(que.size() > 0) {
             mutation++;
            int size = que.size();
            
            while(size-->0) {
                String currWord = que.removeFirst();
                
                char[] currWordArray = currWord.toCharArray();
                
                for(int j=0;j<currWordArray.length;j++) {
                    char temp = currWord.charAt(j);
                    
                    for(char c : alphabetlist) {
                        currWordArray[j] = c;
                        
                        String newFormedWord = new String(currWordArray);
                        System.out.println("newly formed word: "+newFormedWord);
                        
                        if(end.equals(newFormedWord) && bankSet.contains(newFormedWord)){
                            return mutation;
                        }
                        
                        if(!bankSet.contains(newFormedWord)) {
                            continue;
                        }
                        
                        que.addLast(newFormedWord);
                        bankSet.remove(newFormedWord);
                    }
                    
                    currWordArray[j] = temp;
                }
            }
        }
        
        return -1;
    }
}