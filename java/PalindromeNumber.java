public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        
        int high = 1;
        int temp = x;
        while (temp >= 10) {
            temp = temp / 10;
            high = high * 10;
        }
        
        while (high >= 10) {
            int highest = x / high;
            int lowest = x % 10;
            if (highest != lowest) {
                return false;
            }
            
            x = (x % high) / 10;
            high = high / 100;
        }
        
        return true;
    }
}
