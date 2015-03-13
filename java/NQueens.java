import java.util.*;
public class Solution {
    public List<String[]> result = new ArrayList<String[]>();
    public List<String[]> solveNQueens(int n) {
        List<Integer> array = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            array.add(i+1);
        }
        List<Integer> curr = new ArrayList<Integer>();
        this.dfs(curr, array);
        return this.result;
    }

    public void dfs (List<Integer> curr, List<Integer> array) {
        if (array.size() == 0) {
            this.result.add(this.construct(curr));
            return;
        }
        for (int i = 0; i < array.size(); i++) {
            if (this.check(curr, array.get(i)) == true) {
                List<Integer> copyCurr = new ArrayList<Integer>(curr);
                copyCurr.add(array.get(i));
                List<Integer> arrayCopy = new ArrayList<Integer>(array);
                arrayCopy.remove(i);
                dfs(copyCurr, arrayCopy);
            }
        }
    }

    public boolean check (List<Integer> curr, int newValue) {
        for (int i = 0; i < curr.size(); i++) {
            if (Math.abs(newValue-curr.get(i)) == Math.abs(curr.size()-i)) {
                return false;
            }
        }
        return true;
    }

    public String[] construct (List<Integer> curr) {
        String[] r = new String[curr.size()];
        for (int i = 0; i < curr.size(); i++) {
            StringBuilder sb = new StringBuilder(curr.size());
            for (int j = 0; j < curr.size(); j++) {
                if ((j + 1) == curr.get(i)) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            r[i] = sb.toString();
        }
        return r;
    }

    public static void main (String args[]) {
        Solution sol = new Solution();
        int n = 2;
        List<String[]> result = sol.solveNQueens(n);
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(result.get(i)[j]);
            }
        }
    }
}


