class Solution {
public:
    std::vector<std::vector<int> > fourSum(std::vector<int> &num, int target) {
        std::unordered_map<int, std::vector<std::pair<int, int>>> dictionary;
        std::sort(num.begin(), num.end());
        std::set<std::vector<int>> result;
        
        for (int i = 0; i < int(num.size()); i ++) {
            for (int j = i; j < int(num.size()); j ++) {
                dictionary[num[i]+num[j]].push_back(std::make_pair(i, j));
            }
        }
        
        for (int i = 0; i < int(num.size()); i ++) {
            if (i != 0 && num[i] == num[i-1]) {
                continue;
            }
            for (int j = i + 1; j < int(num.size()); j ++) {
                int curr = num[i] + num[j];
                if (dictionary.find(target-curr) != dictionary.end()) {
                    std::vector<std::pair<int, int>> sum2 = dictionary[target-curr];
                    for (int k = 0; k < sum2.size(); k ++) {
                        if (sum2[k].first > j) {
                            std::vector<int> item;
                            item.push_back(num[i]);
                            item.push_back(num[j]);
                            item.push_back(num[sum2[k].first]);
                            item.push_back(num[sum2[k].second]);
                            result.insert(item);
                        }
                    }
                }
            }
        }
        
        std::vector<std::vector<int>> resultList;
        
        std::set<std::vector<int>>::iterator set_iter;
        for (set_iter = result.begin(); set_iter != result.end(); set_iter++) {
            resultList.push_back(*set_iter);
        }
        
        return resultList;
    }
};
