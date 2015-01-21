//
//  SearchA2DMatrix.cpp
//  c++
//
//  Created by sure on 1/21/15.
//  Copyright (c) 2015 Shuo Li. All rights reserved.
//

#include <stdio.h>
#include <vector>

class Solution {
public:
    bool searchMatrix(std::vector<std::vector<int>> &matrix, int target) {
        int rows = int(matrix.size());
        int low = 0;
        int high = rows - 1;
        int search_row = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (matrix[mid][0] > target) {
                high = mid - 1;
            } else if (matrix[mid][0] < target) {
                if ((mid + 1) == rows || matrix[mid+1][0] > target) {
                    search_row = mid;
                    break;
                } else {
                    low = mid + 1;
                }
            } else {
                return true;
            }
        }
        
        if (search_row == -1) {
            return false;
        }
        
        low = 0;
        high = int(matrix[0].size());
        
        while (low <= high) {
            int mid = (low + high) / 2;
            if (matrix[search_row][mid] > target) {
                high = mid - 1;
            } else if (matrix[search_row][mid] < target) {
                low = mid + 1;
            } else {
                return true;
            }
        }
        
        return false;
    }
};
