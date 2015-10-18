class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int start = 0;
        unordered_map<char, int> map;
        int result = 0;
        for (int i = 0; i < (int)s.length(); i++) {
            if (map.find(s.at(i)) != map.end()) {
                int temp = map[s.at(i)];
                while (start <= temp) {
                    map.erase(s.at(start));
                    start ++;
                }
            }
            map[s.at(i)] = i;
            result = max(result, i - start + 1);
        }
        return result;
    }
};
