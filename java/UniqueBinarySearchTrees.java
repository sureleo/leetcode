public class Solution {
    public int numTrees(int n) {
        int[] opt = new int[n+1];
        opt[0] = 1;
        if (n == 0) {
            return opt[0];
        }
        opt[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                opt[i] += opt[j] * opt[i-j-1];
            }
        }
        return opt[n];
    }
}
