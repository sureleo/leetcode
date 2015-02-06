//
//  LongestSubstringWithoutRepeatingCharacters.cpp
//  c++
//
//  Created by sure on 1/22/15.
//  Copyright (c) 2015 Shuo Li. All rights reserved.
//

#include <stdio.h>
#include <map>
#include <iostream>

class Solution {
public:
    int lengthOfLongestSubstring(std::string s) {
        int result = 0;
        int start = 0;
        std::map<char, int> dict;
        for (int i = 0; i < s.length(); i ++) {
            std::map<char, int>::const_iterator it = dict.find(s.at(i));
            if (it != dict.end()) {
                int temp = dict.at(s.at(i));
                while (start <= temp) {
                    dict.erase(s.at(start));
                    start ++;
                }
            }
            dict.insert(std::pair<char, int>(s.at(i), i));
            if ((i - start + 1) > result) {
                result = i - start + 1;
            }
        }
        return result;
        
    }
};


int main() {
    Solution *s = new Solution();
    int result = s->lengthOfLongestSubstring("wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco");
    std::cout<<result<<std::endl;
}
