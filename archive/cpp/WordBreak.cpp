#include <unordered_set>
#include <string>
#include <iostream>
#include <vector>

class Solution {
public:
    bool wordBreak(std::string s, std::unordered_set<std::string> &dict) {
        //use vector instead of array in any case
        std::vector<bool> opt(s.length()+1, false);
        opt[0] = true;
        int j = 0;
        for (int i = 0; i < s.length()+1; i++) {
            for (int j = 1; j < s.length() + 1; j++) {
                if (opt[i] && (dict.find(s.substr(i, j-i)) != dict.end())) {
                    opt[j] = true;
                }
            }
        }
        return opt[s.length()];
    }
};

int main () {
    Solution *s = new Solution();
    std::unordered_set<std::string> dict;
    dict.insert("b");
    bool result = s->wordBreak("a", dict);
    delete s;
    std::cout<<result<<std::endl;
}
