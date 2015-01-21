//
//  FindPeakElement.cpp
//  c++
//
//  Created by sure on 1/21/15.
//  Copyright (c) 2015 Shuo Li. All rights reserved.
//

#include <stdio.h>
#include <vector>

class Solution {
public:
    int findPeakElement(const std::vector<int> &num) {
        int low = 0;
        int high = int(num.size());
        if (low == high - 1) {
            return low;
        }
        
        while (low <= high) {
            int mid = (low + high) / 2;
            if (mid == 0 && num[mid] > num[mid+1]) {
                return mid;
            }
            if (mid == (num.size() - 1) && num[mid] > num[mid-1]) {
                return mid;
            }
            if (num[mid] > num[mid-1] and num[mid] > num[mid+1]) {
                return mid;
            } else if (num[mid] > num[mid-1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return 0;
    }
};
