class Solution {
    public int maxLength(List<String> arr) {
        int ans = helper(arr,"",0);
        return ans;
    }
    public int helper(List<String> arr,String ans,int index) {
        if(index == arr.size()) {
            if(isValidSoFar(ans)) {
                return ans.length();
            }
            return 0;
        }
        
        int sizeAppend = helper(arr,ans,index+1);
        int sizeWithoutAppend = helper(arr,ans+arr.get(index),index+1);
        
        return Math.max(sizeAppend,sizeWithoutAppend);
    }
    public boolean isValidSoFar(String s) {
        HashSet<Character> set = new HashSet<>();
        
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            if(set.contains(ch)) {
                return false;
            }
            set.add(ch);
        }
        
        return true;
    }
}    