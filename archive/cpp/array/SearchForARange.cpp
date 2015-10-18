class Solution {
public:
    vector<int> searchRange(int A[], int n, int target) {
        vector<int> result;
        int mid = this->checkExist(A, n, target);
        if (mid == -1) {
            result.push_back(-1);
            result.push_back(-1);
        } else {
            result.push_back(this->searchLeft(A, target, mid));
            result.push_back(this->searchRight(A, n, target, mid));
        }
        return result;
    }
    
public:
    int checkExist(int A[], int n, int target) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
    
public:
    int searchLeft(int A[], int target, int mid) {
        int low = 0;
        int high = mid;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (A[mid] == target) {
                high = mid - 1;
            } else {
                if (A[mid+1] == target) {
                    return mid + 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return low;
    }

public:
    int searchRight(int A[], int n, int target, int mid) {
        int low = mid;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (A[mid] == target) {
                low = mid + 1;
            } else {
                if (A[mid-1] == target) {
                    return mid - 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return high;
    }
};
