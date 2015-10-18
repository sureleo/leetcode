//
//  3SumClosest.cpp
//  c++
//
//  Created by sure on 1/25/15.
//  Copyright (c) 2015 Shuo Li. All rights reserved.
//

#include <stdio.h>
#include <stdlib.h>
#include <vector>
#include <iostream>


class Solution {
public:
    int threeSumClosest(std::vector<int> &num, int target) {
        std::sort(num.begin(), num.end());
        int low = 0;
        int high = int(num.size() - 1);
        int result = num[0] + num[high] + num[1];
        int closest = abs(num[0] + num[high] + num[1] - target);
        while (high - low > 1) {
            int curr = num[low] + num[high];
            for (int i = low + 1; i < high; i ++) {
                int temp = curr + num[i];
                int diff = abs(target-temp);
                if (diff == 0) {
                    return target;
                }
                if (diff < closest) {
                    closest = diff;
                    result = temp;
                }
            }
            if (curr < target) {
                low ++;
            } else if (curr > target) {
                high --;
            } else {
                if (abs(num[high]) > abs(num[low])) {
                    high --;
                } else {
                    low ++;
                }
            }
        }
        return result;
    }
};
