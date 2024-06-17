class Solution {
    public boolean judgeSquareSum(int c) {
        
        long root = 0;  // Initialize variable to store the largest possible root
        long l = 1;     // Left pointer starts at 1
        long r = c;     // Right pointer starts at c
        
        // Binary search to find the integer square root of c
        while (l <= r) {
            long mid = l + (r - l) / 2;  // Calculate mid point
            long prod = mid * mid;       // Calculate square of mid
            if (prod == c) return true;  // If square of mid equals c, return true
            if (prod > c) {
                r = mid - 1;             // If square of mid is greater than c, move right pointer left
            } else {
                root = mid;              // Update root to mid
                l = mid + 1;             // Move left pointer right
            }
        }
        
        l = 0;           // Reset left pointer to 0
        r = root; 
            
        
        while(l<=r) {
            long prod = (l*l) + (r * r);
            
            if(prod == c) return true;
            
            if(c < prod) {
                r--;
            } else {
                l++;
            }
        }
        
        
        return false;
    }
}