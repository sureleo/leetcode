public class Solution {
    public int numSquares(int n) {
        int opt[] = new int[n+1];
        int maxSquare = (int) Math.sqrt(n);
        opt[0] = 0;
        opt[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            int currMin = opt[i-1] + 1;
            for (int j = 2; j <= maxSquare; j++) {
                if (i >= j * j) {
                    currMin = Math.min(currMin, opt[i-j*j] + 1);
                }
            }
            
            opt[i] = currMin;
        }
        
        return opt[n];
    }
}
