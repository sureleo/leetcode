//
//  LongestPalindromeSubstring.cpp
//  c++
//
//  Created by sure on 1/22/15.
//  Copyright (c) 2015 Shuo Li. All rights reserved.
//

#include <stdio.h>
#include <iostream>

class Solution {
public:
    std::string longestPalindrome(std::string s) {
        int curr_max = 1;
        std::string max_result = &s.at(0);
        
        for (int i = 0; i < s.length(); i ++) {
            std::string curr_result = this->expand(s, i, i);
            if (curr_result.length() > curr_max) {
                max_result = curr_result;
                curr_max = int(curr_result.length());
            }
        }
        
        for (int i = 0; i < s.length() - 1; i ++) {
            std::string curr_result = this->expand(s, i, i);
            if (curr_result.length() > curr_max) {
                max_result = curr_result;
                curr_max = int(curr_result.length());
            }
        }
        
        return max_result;
    }
    
public:
    std::string expand(std::string s, int left, int right) {
        while (left >= 0 && right <= s.length() - 1 && s.at(left) == s.at(right)) {
            left --;
            right ++;
        }
        return s.substr(left+1, right-left-1);
    }
};


int main() {
    Solution *s = new Solution();
    std::string result = s->longestPalindrome("dacafe");
    std::cout<<result<<std::endl;
}
