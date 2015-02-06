class Solution {
public:
    int removeDuplicates(int A[], int n) {
        int result = n;
        if (result == 0) {
            return result;
        }
        
        int next_index = 1;
        int curr = 0;
        for (int i = 1; i < n; i++){
            if (A[i] > A[curr]) {
                A[next_index] = A[i];
                curr = i;
                next_index ++;
            } else {
                result --;
            }
        }
        
        return result;
    }
};
