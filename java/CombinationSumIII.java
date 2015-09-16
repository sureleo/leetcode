public class Solution {
    public int end = 9;

    public List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> curr = new ArrayList<Integer>();
        this.dfs(1, k, n, curr);
        return result;
    }

    public void dfs(int start, int k, int n, List<Integer> curr) {
        if (n == 0) {
            if (k == 0) {
                result.add(curr);
                return;
            } else {
                return;
            }
        }

        if (n < 0 || k * end < n) {
            return;
        }

        for (int i = start; i <= end; i++) {
            List<Integer> next = new ArrayList<Integer>(curr);
            next.add(i);
            this.dfs(i+1, k-1, n-i, next);
        }
    }
}
