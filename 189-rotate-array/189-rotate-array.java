class Solution {
    public void reverseArray(int[] a,int apos,int bpos) {
        while(apos<bpos) {
            int temp = a[apos];
            a[apos] = a[bpos];
            a[bpos] = temp;
            apos++;
            bpos--;
        }
    }
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if(k>n) {
            k = k % n;
        }
        reverseArray(nums,0,n-k-1);
        reverseArray(nums,n-k,n-1);
        reverseArray(nums,0,n-1);
    }
}