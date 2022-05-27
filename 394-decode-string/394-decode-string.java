class Solution {
    public String decodeString(String s) {
        Stack<Integer> st = new Stack<>();
        Stack<String> sts  = new Stack<>();
        
        String number = "";
        StringBuilder word = new StringBuilder();
        
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            
            if(Character.isDigit(ch)) {
                number = number+ch;
            } else if(Character.isLetter(ch)) {
                word.append(ch);
            } else if(ch == '[') {
                st.push(Integer.parseInt(number));
                sts.push(word.toString());
                number = "";
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