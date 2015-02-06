class Solution {
public:
    bool canJump(int A[], int n) {
        if (n == 0 || n == 1) {
            return true;
        }
        int maxCanReach = A[0];
        int i = 1;
        while (i < maxCanReach + 1) {
            maxCanReach = std::max(A[i] + i, maxCanReach);
            if (maxCanReach >= n - 1) {
                return true;
            }
            i ++;
        }
        return false;
    }
};
