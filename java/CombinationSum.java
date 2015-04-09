public class Solution {
    public List<List<Integer>> result = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> valuelist = new ArrayList<Integer>();
        this.dfs(candidates, valuelist, target, 0);
        return this.result;
    }
    
    public void dfs(int[] candidates, List<Integer> valuelist, int target, int start) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            this.result.add(valuelist);
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            List<Integer> newList = new ArrayList<Integer>(valuelist);
            newList.add(candidates[i]);
            this.dfs(candidates, newList, target-candidates[i], i);
        }
    }
}
