#include <vector>
#include <unordered_map>

class Solution {
public:
    std::vector<int> twoSum(std::vector<int> &numbers, int target) {
        std::vector<int> result;
        std::unordered_map<int, int> map;
        for (int i = 0; i < (int)numbers.size(); i ++) {
            if (map.find(numbers[i]) != map.end()) {
                result.push_back(map.find(numbers[i])->second + 1);
                result.push_back(i+1);
            } else {
                map[target-numbers[i]] = i;
            }
        }
        return result;
    }
};
