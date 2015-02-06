class Solution {
public:
    int findMin(vector<int> &num) {
        int low = 0;
        int high = int(num.size()) - 1;
        while (low < high - 1) {
            int mid = (low + high) / 2;
            if (num[mid] > num[high]) {
                low = mid;
            } else {
                high = mid;
            }
        }
        
        return std::min(num[low], num[high]);
    }
};
