public class Solution {
    public List<List<Integer>> result = new ArrayList<List<Integer>>();
    public int max_depth = 0;
    public List<List<Integer>> combine(int n, int k) {
        this.max_depth = k;
        List<Integer> arr = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            arr.add(i+1);
        }
        List<Integer> valuelist = new ArrayList<Integer>();
        this.dfs(arr, valuelist);
        return this.result;
    }
    
    public void dfs(List<Integer> arr, List<Integer> valuelist) {
        if (valuelist.size() == this.max_depth) {
            this.result.add(valuelist);
            return;
        }
        if (arr.size() == 0) {
            return;
        }
        for (int i = 0; i < arr.size(); i++) {
            List<Integer> copy = new ArrayList<Integer>(valuelist);
            copy.add(arr.get(i));
            dfs(arr.subList(i+1, arr.size()), copy);
        }
    }
}
