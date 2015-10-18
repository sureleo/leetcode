//
//  SubstringWithConcatenationOfAllWords.cpp
//  c++
//
//  Created by sure on 1/23/15.
//  Copyright (c) 2015 Shuo Li. All rights reserved.
//

#include <stdio.h>
#include <vector>
#include <string>
#include <map>

class Solution {
public:
    std::vector<int> findSubstring(std::string S, std::vector<std::string> &L) {
        std::vector<int> result;
        std::map<std::string, int> dictionary;
        int count = int(L.size());
        for (int i = 0; i < count; i ++) {
            std::map<std::string, int>::iterator it = dictionary.find(L[i]);
            if (it == dictionary.end()) {
                dictionary.insert(std::pair<std::string, int> (L[i], 1));
            } else {
                it->second ++;
            }
        }
        
        for (int i = 0; i < S.length() - L.size() * L[0].length() + 1; i ++) {
            std::map<std::string, int> curr;
            int j = 0;
            while (j < L.size()) {
                std::string temp = S.substr(i+j*L[0].length(), L[0].length());
                std::map<std::string, int>::iterator it = dictionary.find(temp);
                if (it != dictionary.end()) {
                    std::map<std::string, int>::iterator it_curr = curr.find(temp);
                    if (it_curr == curr.end()) {
                        curr.insert(std::pair<std::string, int> (temp, 1));
                    }
                    else {
                        it_curr->second ++;
                    }
                    if (curr.find(temp)->second > dictionary.find(temp)->second) {
                        break;
                    } else {
                        count -= 1;
                    }
                    if (count == 0) {
                        result.push_back(i);
                    }
                }
                j ++;
            }
            count = int(L.size());
        }
        return result;
    }
};
