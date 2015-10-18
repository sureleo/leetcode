#include <vector>
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    TreeNode *sortedArrayToBST(std::vector<int> &num) {
        int low = 0;
        int high = num.size() - 1;
        int mid = (low + high) / 2;
        if ((int)num.size() == 0) {
            return NULL;
        }
        TreeNode *root = new TreeNode(num[mid]);
        std::vector<int> low_half (num.begin(), num.begin()+mid-low);
        std::vector<int> high_half (num.begin()+mid+1, num.begin()+1+high);
        root->left = this->sortedArrayToBST(low_half);
        root->right = this->sortedArrayToBST(high_half);
        return root;
    }
};
