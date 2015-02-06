//
//  SimplifyPath.cpp
//  c++
//
//  Created by sure on 1/22/15.
//  Copyright (c) 2015 Shuo Li. All rights reserved.
//

#include <stdio.h>
#include <string>
#include <sstream>
#include <stack>

class Solution {
public:
    std::string simplifyPath(std::string path) {
        std::string result = "/";
        std::istringstream ss(path);
        std::string token;
        std::stack<std::string> s;
        while(std::getline(ss, token, '/')) {
            if (token == "" || token == ".") {
                continue;
            } else if (token == "..") {
                if (s.size() == 0) {
                    continue;
                } else {
                    s.pop();
                }
            } else {
                s.push(token);
            }
        }
        
        std::stack<std::string> temp;
        while (s.size() > 0) {
            temp.push(s.top());
            s.pop();
        }
        
        while (temp.size() > 0) {
            result += temp.top();
            temp.pop();
            if (temp.size() != 0) {
                result += "/";
            }
        }
        
        return result;
    }
};
