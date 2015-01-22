//
//  MaximumGap.cpp
//  c++
//
//  Created by sure on 1/21/15.
//  Copyright (c) 2015 Shuo Li. All rights reserved.
//
// Another solution from leetcode oj and https://github.com/haoel/leetcode/blob/master/src/maximumGap/maximumGap.cpp

#include <stdio.h>
#include <vector>
#include <iostream>
#include <math.h>

class Solution {
public:
    int maximumGap(std::vector<int> &num) {
        int result = 0;
        if (num.size() < 2) {
            return result;
        }
        int min = num[0];
        int max = num[0];
        for (int i = 0; i < num.size(); i ++) {
            min = std::min(min, num[i]);
            max = std::max(max, num[i]);
        }
        int bucket_size = (max - min) / num.size() + 1;

        std::vector<std::vector<int>> buckets ((max-min)/bucket_size + 1);
        for (int i = 0; i < num.size(); i ++) {
            int index = (num[i] - min) / bucket_size;
            if (buckets[index].empty()) {
                buckets[index].push_back(num[i]);
                buckets[index].push_back(num[i]);
            } else {
                buckets[index][0] = std::min(buckets[index][0], num[i]);
                buckets[index][1] = std::max(buckets[index][1], num[i]);
            }
        }
        
        int prev = 0;
        for (int i = 0; i < buckets.size(); i ++) {
            if (buckets[i].empty()) {
                continue;
            }
            result = std::max(buckets[i][0] - buckets[prev][1], result);
            prev = i;
        }
        
        return result;
    }
};


int main() {
    Solution *s = new Solution();
    int A[2] = {1,10000000};
    std::vector<int> myVecotr (A, A+2);
    int result = s->maximumGap(myVecotr);
    std::cout<< result << std::endl;
}
