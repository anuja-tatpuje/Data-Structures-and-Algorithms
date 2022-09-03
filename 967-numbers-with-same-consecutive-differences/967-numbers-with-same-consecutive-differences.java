class Solution {
    List<Integer> list = new ArrayList<>();
    public int[] numsSameConsecDiff(int n, int k) {
        for(int num=1;num<=9;num++) {
             helper(num,num,n-1,k);
        } 
        
        int[] array = new int[list.size()];
        int idx = 0;
        for(int i : list) {
            array[idx] = i;
            idx++;
        }
        
        return array;
    }
    public void helper(int num,int digit,int n,int k) {
        if(n == 0) {
            list.add(num);
            return;
        }
        for(int i=0;i<=9;i++) {
            if(Math.abs(i-digit) == k) {
              helper(num*10+i,i,n-1,k);   
            }    
        } 
    }
}