class Solution {
    public int compress(char[] chars) {
        if(chars.length == 1) 
            return 1;
        String finalString = "";
        int cnt = 1;
        StringBuilder sb = new StringBuilder();
        sb.append(chars[0]);
        for(int i=1;i<chars.length;i++) {
            char curr = chars[i];
            char prev = chars[i-1];
            if(curr == prev) {
                cnt++;
            } else {
                if(cnt > 1) {
                     sb.append(cnt);
                    cnt = 1;
                }
                sb.append(curr);
                cnt = 1;
            }
        }
        if(cnt>1) {
            sb.append(cnt);
        }
        finalString = sb.toString();
        
        for(int i=0;i<finalString.length();i++) {
            chars[i] = finalString.charAt(i);
        }
        
        return finalString.length();
    }
}