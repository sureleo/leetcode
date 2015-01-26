class Solution {
public:
    std::vector<std::vector<int> > threeSum(std::vector<int> &num) {
        std::vector<std::vector<int>> result;
        std::sort(num.begin(), num.end());
        if (num.size() == 0) {
            return result;
        }
        
        for(int i = 0; i < int(num.size()) - 2; i ++) {
            if (i == 0 || num[i] > num[i-1]) {
                int left = i + 1;
                int right = int(num.size() - 1);
                while (left < right) {
                    int curr = num[left] + num[right] + num[i];
                    if (curr == 0) {
                        std::vector<int> item;
                        item.push_back(num[i]);
                        item.push_back(num[left]);
                        item.push_back(num[right]);
                        result.push_back(item);
                        int newLeft = left;
                        while (newLeft < right && num[newLeft] == num[left]) {
                            newLeft ++;
                        }
                        left = newLeft;
                        
                        int newRight = right;
                        while (left < newRight && num[newRight] == num[right]) {
                            newRight --;
                        }
                        right = newRight;
                    } else if (curr > 0) {
                        int newRight = right;
                        while (left < newRight && num[newRight] == num[right]) {
                            newRight --;
                        }
                        right = newRight;
                    } else {
                        int newLeft = left;
                        while (newLeft < right && num[newLeft] == num[left]) {
                            newLeft ++;
                        }
                        left = newLeft;
                    }
                }
            } else {
                continue;
            }
        }
        return result;
    }
};
