#include <vector>
#include <string>

class Solution {
public:
    std::vector<std::string> fullJustify(std::vector<std::string> &words, int L) {
        std::vector<std::string> result;
        std::vector<std::string> curr_line;
        int curr_length = 0;
        std::string curr = "";

        for (int i = 0; i < words.size(); i ++) {
            if (curr_line.size() == 0 || (curr_length + words[i].length() + 1) <= L) {
                curr_line.push_back(words[i]);
                curr_length += words[i].length();
                if (curr_line.size() != 1) {
                    curr_length ++;
                }
            } else {
                if (curr_line.size() == 1) {
                    curr += curr_line[0]  + std::string(L-curr_line[0].length(), ' ');
                } else {
                    int total_space = L - curr_length;
                    int per_space = total_space / (curr_line.size() - 1);
                    int mod_space = total_space % (curr_line.size() - 1);
                    for (int j = 0; j < curr_line.size(); j ++) {
                        curr += curr_line[j];
                        if (j != curr_line.size() - 1) {
                            curr += std::string(per_space+1, ' ');
                        }
                        if (mod_space != 0) {
                            curr += " ";
                            mod_space --;
                        }
                    }
                }
                result.push_back(curr);
                curr = "";
                std::string temp[] = {words[i]};
                curr_line = std::vector<std::string> (temp, temp + sizeof(temp) / sizeof(temp[0]));
                curr_length = words[i].length();
            }
        }
        std::string last_line = "";
        for (int i = 0; i < curr_line.size(); i ++) {
            if (i != 0) {
                last_line += " ";
            }
            last_line += curr_line[i];
        }

        result.push_back(last_line + std::string(L-last_line.length(), ' '));
        return result;
    }
};
