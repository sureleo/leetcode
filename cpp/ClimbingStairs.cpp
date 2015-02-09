class Solution {
public:
    int climbStairs(int n) {
        vector<int> opt (n+1, 0);
        opt[0] = 1;
        if (n > 0) {
            opt[1] = 1;
        }
        for (int i = 2; i < n+1; i++) {
            opt[i] = opt[i-1] + opt[i-2];
        }
        return opt[n];
    }
};
