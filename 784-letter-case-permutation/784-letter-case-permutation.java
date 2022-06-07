class Solution {
    List<String> letterCase = new ArrayList<>();
    public List<String> letterCasePermutation(String s) {
        helper(s.toCharArray(),0);
        return letterCase;
    }
    public void helper(char[] s,int index) {
        if(index == s.length) {
            letterCase.add(new String(s));
            return;
        }
        if(s[index] >= '0' && s[index] <= '9') {
            helper(s,index+1);
            return;
        }
        
        s[index] = Character.toLowerCase(s[index]);
        helper(s,index+1);
        
        s[index] = Character.toUpperCase(s[index]);
        helper(s,index+1);
    }
}