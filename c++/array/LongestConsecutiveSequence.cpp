class Solution {
public:
    int longestConsecutive(std::vector<int> &num) {
        std::unordered_map<int, bool> dictionary;
        int result = 0;
        for (int i = 0; i < int(num.size()); i ++) {
            dictionary[num[i]] = false;
        }
        
        for (int i = 0; i < int(num.size()); i ++) {
            int curr = 1;
            dictionary[num[i]] = 0;
            int left = num[i] - 1;
            while (dictionary.find(left) != dictionary.end() and !dictionary[left]) {
                dictionary[left] = true;
                curr ++;
                left --;
            }
            int right = num[i] + 1;
            while (dictionary.find(right) != dictionary.end() and !dictionary[right]) {
                dictionary[right] = true;
                curr ++;
                right ++;
            }
            result = std::max(curr, result);
        }
        
        return result;
    }
};
