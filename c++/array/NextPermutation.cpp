//
//  NextPermutation.cpp
//  c++
//
//  Created by sure on 1/19/15.
//  Copyright (c) 2015 Shuo Li. All rights reserved.
//

#include <stdio.h>
#include <vector>
#include <iostream>

class Solution {
public:
    void nextPermutation(std::vector<int> &num) {
        int vioIndex = 0;
        for (int i = int(num.size())-2; i >= 0; i--) {
            if (num[i] < num[i+1]) {
                vioIndex = i;
                break;
            }
            else {
                if (i == 0) {
                    vioIndex = -1;
                }
            }
        }
        
        if (vioIndex == -1) {
            std::reverse(num.begin(), num.end());
            return;
        }
        
        for (int i = int(num.size())-1; i >= 0; i--) {
            if (num[i] > num[vioIndex]) {
                int temp = num[i];
                num[i] = num[vioIndex];
                num[vioIndex] = temp;
                break;
            }
        }
        
        int temp;
        int start = vioIndex + 1;
        int end = int(num.size()) - 1;
        while (start < end) {
            temp = num[start];
            num[start] = num[end];
            num[end] = temp;
            start++;
            end--;
        }
        return;
    }
};

int main() {
    Solution *s = new Solution();
    int myints[] = {1, 3, 2};
    std::vector<int> myvector (myints, myints + sizeof(myints) / sizeof(int) );
    s->nextPermutation(myvector);
    for (std::vector<int>::iterator it = myvector.begin(); it != myvector.end(); ++it){
        std::cout << ' ' << *it;
    }
    std::cout << '\n';

    return 0;
}
