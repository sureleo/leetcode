// http://blog.csdn.net/xudli/article/details/46798619
// I could never think of this solution.

class Solution {
    public int countDigitOne(int n) {
        int ones = 0;
        for (long m = 1; m <= n; m *= 10) {
            long a = n / m;
            ones += (a+8) / 10 * m;
            long b = n % m;
            if (a % 10 == 1) {
                ones += (b + 1);
            }
        }
        
        return ones;
    }
}
