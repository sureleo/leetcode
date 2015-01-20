//
//  SortColors.cpp
//  c++
//
//  Created by sure on 1/20/15.
//  Copyright (c) 2015 Shuo Li. All rights reserved.
//
// Mistake was made: when i == blue + 1, then left of the array are all 2s,
// No need to continue any more
// Know sth new: std::swap
// Thanks for the hint from: http://fisherlei.blogspot.com/2013/01/leetcode-sort-colors.html

#include <stdio.h>
#include <iostream>

class Solution {
public:
    void sortColors(int A[], int n) {
        int red = 0;
        int blue = n - 1;
        for (int i = 0; i < n; i++) {
            if (i == blue + 1) {
                break;
            }
            if (A[i] == 0) {
                std::swap(A[red], A[i]);
                red ++;
                continue;
            }
            if (A[i] == 2) {
                std::swap(A[blue], A[i]);
                blue --;
                i --;
            }
        }
    }
};

int main() {
    Solution *s = new Solution();
    int A[1] = {2};
    s->sortColors(A, 1);
    for (int i = 0; i < sizeof(A)/sizeof(*A); i++) {
        std::cout<<A[i]<<std::endl;
    }
    
    delete s;

    return 0;
}
