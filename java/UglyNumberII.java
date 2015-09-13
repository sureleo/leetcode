public class Solution {
    public int nthUglyNumber(int n) {
        int opt[] = new int[n];
        opt[0] = 1;
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        for (int i = 1; i < n; i++) {
            opt[i] = Math.min(Math.min(opt[i2] * 2, opt[i3] * 3), opt[i5] * 5);
            if (opt[i] == opt[i2] * 2) {
                i2 += 1;
            }
            
            if (opt[i] == opt[i3] * 3) {
                i3 += 1;
            }
            
            if (opt[i] == opt[i5] * 5) {
                i5 += 1;
            }
        }
        
        return opt[n-1];
    }
}
