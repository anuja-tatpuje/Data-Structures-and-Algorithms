class Solution {
    public boolean makesquare(int[] matchsticks) {
        int len = matchsticks.length;
        int sum = 0;
        for(int num : matchsticks) {
          sum += num;   
        }
        
        if(sum % 4 != 0) {
            return false;
        }
        boolean[] vis = new boolean[len];
        Arrays.sort(matchsticks);
        return rec(matchsticks,0,0,sum/4,4,vis);
    }
    public boolean rec(int[] arr,int idx,int currSum,int tar,int k,boolean[] visited) {
        if(k==0) return true;
        
        if(currSum == tar) return rec(arr,0,0,tar,k-1,visited);
        
        for(int i=idx;i<arr.length;i++) {
            if(visited[i]) continue;
            
            visited[i] = true;
            if(rec(arr,i+1,currSum+arr[i],tar,k,visited)) return true;
            visited[i] = false;
        }
        
        return false;
    }
}