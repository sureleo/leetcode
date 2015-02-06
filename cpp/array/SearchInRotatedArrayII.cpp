//Time complexity changed to O(n) if there's duplicates.
//1, 3, 1, 1, 1 and 1, 1, 1, 3, 1
//target = 3, you can't tell 3 is in the lower or higher part
class Solution {
public:
    bool search(int A[], int n, int target) {
        for (int i = 0; i < n; i ++) {
            if (A[i] == target) {
                return true;
            }
        }
        return false;
    }
};
