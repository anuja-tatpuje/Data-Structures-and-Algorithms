class Solution {
    public String decodeString(String s) {
        Stack<Integer> st = new Stack<>();
        Stack<String> sts  = new Stack<>();
        
        int number = 0;
        StringBuilder word = new StringBuilder();
        int index = 0;
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            
            if(Character.isDigit(ch)) {
                number = number * 10 + (ch - '0');
            } else if(Character.isLetter(ch)) {
                word.append(ch);
            } else if(ch == '[') {
                st.push(number);
                sts.push(word.toString());
                number = 0;
                word = new StringBuilder();
            } else {
                String firstWord = sts.pop();
                int k = st.pop();
                StringBuilder duplicate = new StringBuilder(firstWord);
                for(int f=0;f<k;f++) {
                    duplicate.append(word);
                }
                word = duplicate;
            }
        }
        
        return word.toString();
    }
}