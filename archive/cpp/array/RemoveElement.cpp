class Solution {
public:
    int removeElement(int A[], int n, int elem) {
        int result = n;
        int start = 0;
        for (int i = 0; i < n; i ++) {
            A[start] = A[i];
            if (A[i] != elem) {
                start ++;
            } else {
                result --;
            }
        }
        return result;
    }
};
