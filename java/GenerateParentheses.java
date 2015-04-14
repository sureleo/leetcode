public class Solution {
    public int n;
    public List<String> result = new ArrayList<String>();
    public List<String> generateParenthesis(int n) {
        this.n = n;
        StringBuilder valuelist = new StringBuilder();
        this.dfs(0, 0, valuelist);
        return this.result;
    }
    
    public void dfs(int left, int right, StringBuilder valuelist) {
        if (left == this.n && right == this.n) {
            this.result.add(valuelist.toString());
            return;
        }
        if (right > left || left > this.n) {
            return;
        }
        if (left > right) {
            StringBuilder newList = new StringBuilder(valuelist);
            newList.append(')');
            this.dfs(left, right+1, newList);
        }
        StringBuilder newList = new StringBuilder(valuelist);
        newList.append('(');
        this.dfs(left+1, right, newList);
    }
}
