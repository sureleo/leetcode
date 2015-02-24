import java.util.*;
public class Solution {
    public List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> permute(int[] num) {
        List<Integer> valuelist = new ArrayList<Integer>();
        this.dfs(num, valuelist);
        return this.result;
    }

    public void dfs(int[] num, List<Integer> valuelist) {
        if (num.length == 0) {
            this.result.add(valuelist);
            return;
        }
        for (int i = 0; i < num.length; i++) {
            List<Integer> copy = new ArrayList<Integer>(valuelist);
            copy.add(num[i]);
            int[] first_half = Arrays.copyOfRange(num, 0, i);
            int[] second_half = Arrays.copyOfRange(num, i+1, num.length);
            int[] newArray = new int[num.length-1];
            System.arraycopy(first_half, 0, newArray, 0, first_half.length);
            System.arraycopy(second_half, 0, newArray, i, second_half.length);
            dfs(newArray, copy);
        }
    }
}
