class Solution {
public:
    int jump(int A[], int n) {
        int times = 0;
        int i = 0;
        int maxCanReach = 0;
        int temp = 0;
        while (i < n) {
            if (temp >= n - 1) {
                break;
            }
            while (i < temp + 1) {
                maxCanReach = max(maxCanReach, A[i] + i);
                i ++;
            } 
            times ++;
            temp = maxCanReach;
        }
        return times;
    }
};
