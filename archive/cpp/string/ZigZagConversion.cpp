//
//  ZigZagConversion.cpp
//  c++
//
//  Created by sure on 1/19/15.
//  Copyright (c) 2015 Shuo Li. All rights reserved.
//

#include <stdio.h>
#include <vector>
#include <iostream>

//I have no idea why leetcode gives me output limit exceed by this solution.
//It would be great if any body helped.
class SolutionCantPassOJ {
public:
    std::string convert(std::string s, int nRows) {
        std::string result = "";
        if (nRows == 1) {
            return s;
        }
        
        int group = 2 * nRows - 2;
        int col_per_group = nRows - 2 + 1;
        int num_group = int(s.length()) / group;
        int total_col = num_group * col_per_group;
        int extra = s.length() % group;
        if (extra > nRows) {
            total_col += (extra - nRows);
        }
        if (extra > 0) {
            total_col ++;
        }
        char matrix[nRows][total_col];
        int m = -1;
        bool goDown = true;
        int n = 0;
        for(int i = 0; i < s.length(); i++) {
            if ((m == nRows - 1) && (goDown == true)) {
                goDown = false;
            }
            if (goDown == true) {
                m ++;
            } else {
                m --;
                n ++;
                if (m == 0) {
                    goDown = true;
                }
            }
            matrix[m][n] = s.at(i);
        }
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < total_col; j++) {
                if (isalpha(matrix[i][j])) {
                    result += matrix[i][j];
                }
            }
        }
        
        return result;
    }
};

//This solution is from: https://github.com/jingcmu/leetcode/blob/master/C%2B%2B/ZigZag%20Conversion.cpp
class Solution {
public:
    std::string convert(std::string s, int nRows) {
        std::vector<std::string> rows(nRows);
        std::string solution = "";
        int size = s.size(), cur = 0, dir = 0;
        if(nRows == 1 || nRows > size) {
            return s;
        }
        for(int i=0; i<size; i++) {
            rows[cur]+=s[i];
            if(dir == 0){
                cur++;
                if(cur == nRows-1) {
                    dir = 1;
                }
            }
            else{
                cur--;
                if(cur == 0){
                    dir = 0;
                }
            }
        }
        for(int j=0; j<nRows; j++) {
            solution += rows[j];
        }
        return solution;
    }
};


int main() {
    Solution *s = new Solution();
    std::string result = s->convert("ABC", 2);
    std::cout<<result<<std::endl;
    
    return 0;
}
