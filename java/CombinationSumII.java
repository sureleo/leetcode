import java.util.*;
public class Solution {
    public List<List<Integer>> result = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> valuelist = new ArrayList<Integer>();
        this.dfs(candidates, valuelist, target);
        return this.result;
    }
    
    public void dfs(int[] candidates, List<Integer> valuelist, int target) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            this.result.add(valuelist);
            return;
        }
        for (int i = 0; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i-1]) {
                continue;
            }
            List<Integer> newList = new ArrayList<Integer>(valuelist);
            newList.add(candidates[i]);
            this.dfs(
                Arrays.copyOfRange(candidates, i+1, candidates.length),
                newList,
                target-candidates[i]
            );
        }
    }

    public static void main (String[] args) {
        Solution sol = new Solution();
        int[] candidates = {1};
        int target = 2;
        sol.combinationSum2(candidates, target);
        System.out.println(sol.result);
    }
}
