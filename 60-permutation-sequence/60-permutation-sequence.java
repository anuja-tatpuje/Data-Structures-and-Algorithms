class Solution {
  List<String> list = new ArrayList<>();
    String ans = "";
    int count = 0;
    public String getPermutation(int n, int k) {
        boolean[] vis = new boolean[n+1];
        StringBuilder s = new StringBuilder();
        count = k;
        permutationSequence(n,vis,s);
        return ans;
    }
    public void permutationSequence(int n,boolean[] vis,StringBuilder s) {
        if(count == 0)
            return;
        if(n == s.length()) {
            count--;
            if(count == 0)
                ans = s.toString();
            return;
        }
        for(int i=1;i<=n;i++) {
            if(!vis[i]) {
                vis[i] = true;
                s.append(i);
                permutationSequence(n,vis,s);
                s.deleteCharAt(s.length()-1);
                vis[i] = false;
            }
        }
    }
}