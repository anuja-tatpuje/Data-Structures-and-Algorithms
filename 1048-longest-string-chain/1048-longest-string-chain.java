class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words,(a, b)->Integer.compare(a.length(), b.length()));
        
        int[] dp = new int[words.length];
        int ans = 1;
        for(int curr=0;curr<words.length;curr++) {
            dp[curr] = 1;
            for(int prev = 0; prev < curr; prev++) {
                if(predecessor(words[prev], words[curr])) {
                    dp[curr] = Math.max(dp[curr],dp[prev]+1);
                }
            }
            ans = Math.max(ans,dp[curr]);
        }
        return ans;
    }
    public boolean predecessor(String prev,String curr) {
        int n = prev.length(), m = curr.length();
        
        // as only 1 character can be added to prev to get curr
		if (n+1 != m) {
            return false;
        }

        int i=0, j=0;
		while (j < m) {
            if(i == n) break;
			if (prev.charAt(i) == curr.charAt(j)) {
				i++; 
                j++;
			}
			else j++;
		}

        // if the prev doesn't reach its end then its not predecessor
		return i==n;
    }
}