//http://www.cnblogs.com/zuoyuan/p/3781453.html
//this solution is more easier to implement
class Solution {
public:
    int trap(int A[], int n) {
        vector<int> leftMost;
        int leftMostMax = 0;
        int result = 0;
        for (int i = 0; i < n; i ++) {
            leftMostMax = max(leftMostMax, A[i]);
            leftMost.push_back(leftMostMax);
        }
        
        int rightMostMax = 0;
        for (int i = n - 1; i >= 0; i --) {
            rightMostMax = max(rightMostMax, A[i]);
            result += min(rightMostMax, leftMost[i]) - A[i];
        } 
        return result;
    }
};
