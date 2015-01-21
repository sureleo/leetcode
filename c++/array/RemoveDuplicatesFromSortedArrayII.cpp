//
//  RemoveDuplicatesFromSortedArrayII.cpp
//  c++
//
//  Created by sure on 1/20/15.
//  Copyright (c) 2015 Shuo Li. All rights reserved.
//
// http://blog.csdn.net/myjiayan/article/details/26334279
// Gives me a better solution. Implement it in C++

#include <stdio.h>

class Solution {
public:
    int removeDuplicates(int A[], int n) {
        if (n == 0) {
            return 0;
        }
        int times = 0;
        int index = 0;
        for (int i = 0; i < n; i ++) {
            if (A[index] == A[i]) {
                times ++;
                if (times == 2) {
                    index ++;
                    A[index] = A[i];
                }
            } else {
                index ++;
                A[index] = A[i];
                times = 1;
            }
        }
        return (index + 1);
    }
};

int main() {
    Solution *s = new Solution();
    int A[5] = {1, 1, 1, 2, 3};
    s->removeDuplicates(A, 5);
}
