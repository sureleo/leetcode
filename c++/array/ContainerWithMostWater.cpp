class Solution {
public:
    int maxArea(vector<int> &height) {
        int low = 0;
        int high = height.size() - 1;
        int max_water = 0;
        while (low < high) {
            int curr_length = high - low;
            int curr_height = std::min(height[low], height[high]);
            max_water = std::max(curr_length * curr_height, max_water);
            if (height[low] < height[low+1]) {
                low ++;
            } else if (height[high] < height[high-1]) {
                high --;
            } else {
                if (height[low] < height[high]) {
                    low ++;
                } else {
                    high --;
                }
            }
        }
        return max_water;
    }
};
