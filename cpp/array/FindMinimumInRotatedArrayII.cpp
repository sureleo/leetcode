class Solution {
public:
    int findMin(vector<int> &num) {
        return *std::min_element(num.begin(), num.end());
    }
};
