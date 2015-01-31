class Solution {
public:
    int firstMissingPositive(int A[], int n) {
        int i = 0;
        while (i < n) {
            if (i+1 == A[i] || A[i] >= n || A[i] < 0 || A[A[i]-1] == A[i]) {
                i ++;
            } else {
                int temp = A[i];
                int target = A[i] - 1;
                A[i] = A[target];
                A[target] = temp;
            }
        }
        
        for (int i = 0; i < n; i ++) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }
        
        return n + 1;
    }
};
