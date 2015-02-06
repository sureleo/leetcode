class Solution {
public:
    void merge(int A[], int m, int B[], int n) {
        int l = m + n - 1;
        while (m - 1 >= 0 && n - 1 >= 0) {
            if (A[m-1] > B[n-1]) {
                A[l] = A[m-1];
                m --;
            } else {
                A[l] = B[n-1];
                n --;
            }
            l --;
        }
        while (m - 1 >= 0) {
            A[l] = A[m-1];
            l --;
            m --;
        }
        while (n - 1 >= 0) {
            A[l] = B[n-1];
            l --;
            n --;
        }
    }
};
