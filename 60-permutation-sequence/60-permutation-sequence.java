class Solution {
  List<String> list = new ArrayList<>();
    String ans = "";
    int count = 0;
    public void getPermutations(int n,int k) {
        //calculate factorial
        int fact = 1;
        List<Integer> fa = new ArrayList<>();
        
        for(int i=1;i<n;i++) {
            fact = fact * i;
            fa.add(i);
        }
        fa.add(n);
        
        //reducing k as we have 0 based indexing
         k -= 1;
        while(true) {
            ans += fa.get(k/fact);
            fa.remove(k/fact);
            if(fa.size() == 0) 
                break;
            
            //calculating which index element to take
            k = k % fact;
            fact = fact / fa.size();
        }

    }
    public String getPermutation(int n, int k) {
      /*  boolean[] vis = new boolean[n+1];
        StringBuilder s = new StringBuilder();
        count = k;
        permutationSequence(n,vis,s);
        return ans; */
        
        getPermutations(n,k);
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