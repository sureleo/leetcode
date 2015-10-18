//
//  ReverseWordsInAString.cpp
//  c++
//
//  Created by sure on 1/22/15.
//  Copyright (c) 2015 Shuo Li. All rights reserved.
//

#include <stdio.h>
#include <vector>
#include <stack>
#include <string>
#include <iostream>
#include <sstream>

class Solution {
public:
    void reverseWords(std::string &s) {
        std::istringstream ss(s);
        std::string token;
        
        std::stack<std::string> sta;
        while (std::getline(ss, token, ' ')) {
            if (token.length() == 0) {
                continue;
            }
            sta.push(token);
        }
        
        s = "";
        while (!sta.empty()) {
            s += sta.top();
            if (sta.size() != 1) {
                s += " ";
            }
            sta.pop();
        }
    }
};


int main()
{
    Solution *s = new Solution();
    std::string testString = "The sky is blue";
    s->reverseWords(testString);
    std::cout<<testString<<std::endl;
}
