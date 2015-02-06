/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    vector<int> postorderTraversal(TreeNode *root) {
        TreeNode *node = root;
        TreeNode *lastVisited;
        stack<TreeNode*> s;
        vector<int> result;
        while (!s.empty() || node) {
            if (node) {
                s.push(node);
                node = node->left;
            } else {
                TreeNode *peak = s.top();
                if (peak->right && lastVisited != peak->right) {
                    node = peak->right;
                } else {
                    result.push_back(peak->val);
                    s.pop();
                    lastVisited = peak;
                }
            }
        }
        return result;
    }
};
