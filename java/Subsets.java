import java.util.*;
public class Solution {
    public List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        List<Integer> valuelist = new ArrayList<Integer>();
        this.dfs(S, valuelist);
        return result;
    }

    public void dfs(int[] S, List<Integer> valuelist) {
        this.result.add(valuelist);
        if (S.length == 0) {
            return;
        }
        for (int i = 0; i < S.length; i++) {
            ArrayList<Integer> newList = new ArrayList<Integer>(valuelist);
            newList.add(S[i]);
            dfs(Arrays.copyOfRange(S, i+1, S.length), newList);
        }
    }
}
