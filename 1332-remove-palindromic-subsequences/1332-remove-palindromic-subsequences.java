class Solution {
    public int removePalindromeSub(String s) {
        if(s.length() == 0) return 0;
        
        if(isPallindrome(s)) return 1;
        return 2;
    }
    public boolean isPallindrome(String s) {
        int left = 0, right = s.length() - 1;
        
        while(left<right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
}