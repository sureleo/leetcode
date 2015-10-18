class Solution {
public:
    int largestRectangleArea(std::vector<int> &height) {
        height.push_back(0);
        int i = 0;
        int result = 0;
        std::stack<int> stack;
        while (i < int(height.size())) {
            if (stack.empty() || height[stack.top()] <= height[i]) {
                stack.push(i);
                i ++;
            } else {
                int length = height[stack.top()];
                stack.pop();
                int width;
                if (stack.empty()) {
                    width = i;
                } else {
                    width = i - stack.top() - 1;
                }
                result = std::max(length * width, result);
            }
        }
        return result;
    }
};
