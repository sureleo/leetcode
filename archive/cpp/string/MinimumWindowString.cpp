//
//  MinimumWindowString.cpp
//  c++
//
//  Created by sure on 1/23/15.
//  Copyright (c) 2015 Shuo Li. All rights reserved.
//

#include <stdio.h>
#include <string>
#include <map>

class Solution {
public:
    std::string minWindow(std::string S, std::string T) {
        int count = int(T.length());
        int start = 0;
        int minLength = 100000000;
        std::string result = "";
        std::map<char, int> dictionary;
        for (int i = 0; i < T.length(); i ++) {
            std::map<char, int>::iterator it = dictionary.find(T.at(i));
            if (it == dictionary.end()) {
                dictionary.insert(std::pair<char, int> (T.at(i), 1));
            } else {
                it->second ++;
            }
        }
        
        for (int i = 0; i < S.length(); i ++) {
            std::map<char, int>::iterator it = dictionary.find(S.at(i));
            if (it != dictionary.end()) {
                it->second --;
                if (it->second >= 0) {
                    count --;
                }
                if (count == 0) {
                    while (1) {
                        std::map<char, int>::iterator it = dictionary.find(S.at(start));
                        if (it != dictionary.end()) {
                            if (it->second >= 0) {
                                break;
                            }
                            it->second ++;
                        }
                        start ++;
                    }
                    if ((i - start + 1) < minLength) {
                        result = S.substr(start, i - start + 1);
                        minLength = int(result.length());
                    }
                }
            }
        }
        return result;
    }
};
