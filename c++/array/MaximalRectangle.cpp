//
//  MaximalRectangle.cpp
//  c++
//
//  Created by sure on 1/30/15.
//  Copyright (c) 2015 Shuo Li. All rights reserved.
//

#include <stdio.h>
#include <vector>
#include <stack>

class Solution {
public:
    int maximalRectangle(std::vector<std::vector<char> > &matrix) {
        int result = 0;
        if (matrix.size() == 0) {
            return result;
        }
        std::vector<int> height (matrix[0].size() + 1, 0);
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix[0].size(); j++) {
                if (matrix[i][j] == '0') {
                    height[j] = 0;
                } else {
                    height[j] ++;
                }
            }
            int curr_max = this->doHistogram(height);
            result = std::max(curr_max, result);
        }
        return result;
    }
    
    int doHistogram(std::vector<int> &A) {
        int i = 0;
        int result = 0;
        std::stack<int> s;
        while (i < A.size()) {
            if (s.empty() || A[i] > A[s.top()]) {
                s.push(i);
                i++;
            } else {
                int length = A[s.top()];
                s.pop();
                int width = 0;
                if (s.empty()) {
                    width = i;
                } else {
                    width = i - s.top() - 1;
                }
                result = std::max(length * width, result);
            }
        }
        return result;
    }
};

int main() {
    char A[5] = {'1', '0', '1', '0', '0'};
    char B[5] = {'1', '0', '1', '1', '1'};
    char C[5] = {'1', '1', '1', '1', '1'};
    char D[5] = {'1', '0', '0', '1', '0'};
    std::vector<char> row0 (A, A+5);
    std::vector<char> row1 (B, B+5);
    std::vector<char> row2 (C, C+5);
    std::vector<char> row3 (D, D+5);
    std::vector<std::vector<char>> myvector;
    myvector.push_back(row0);
    myvector.push_back(row1);
    myvector.push_back(row2);
    myvector.push_back(row3);
    
    Solution *s = new Solution();
    s->maximalRectangle(myvector);
}
