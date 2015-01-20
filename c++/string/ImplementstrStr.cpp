//
//  ImplementstrStr.cpp
//  c++
//
//  Created by sure on 1/19/15.
//  Copyright (c) 2015 Shuo Li. All rights reserved.
//
//KMP algorithm. can't get it. Just a simple implementation of
//0. https://www.youtube.com/watch?v=2ogqPWJSftE
//and
//1. http://www.cnblogs.com/zuoyuan/p/3698900.html


#include <stdio.h>
#include <vector>
#include <iostream>

class Solution {
public:
    int strStr(char *haystack, char *needle) {
        int n = int(strlen(haystack));
        int m = int(strlen(needle));
        if (m == 0) {
            return 0;
        }
        std::vector<int> prefix = this->prefixMap(needle);
        int q = 0;
        for (int i = 0; i < n; i++) {
            while ((q > 0) && (needle[q] != haystack[i])) {
                q = prefix[q - 1];
            }
            if (needle[q] == haystack[i]) {
                q ++;
            }
            if (q == m) {
                return i - m + 1;
            }
        }
        return -1;
    }
    
    std::vector<int> prefixMap(char *needle) {
        std::vector<int> pmap (int(strlen(needle)), 0);
        int a = 0;
        for (int b = 2; b < int(strlen(needle)) + 1; b++) {
            while ((a > 0) && (needle[a] != needle[b-1])) {
                a = pmap[a-1];
            }
            if (needle[a] == needle[b-1]) {
                a ++;
            }
            pmap[b-1] = a;
        }
        return pmap;
    }
};

int main() {
    Solution *s = new Solution();
    int result = s->strStr("aaa", "aaa");
    std::cout<<result<<std::endl;
    
    return 0;
}
