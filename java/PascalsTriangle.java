public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numRows == 0) {
            return result;
        }
        List<Integer> curr = new ArrayList<Integer>();
        curr.add(1);
        result.add(curr);
        for (int i = 1; i < numRows; i++) {
            List<Integer> next = new ArrayList<Integer>();
            List<Integer> lastLine = result.get(result.size()-1);
            for (int j = 0; j <= lastLine.size(); j++) {
                int currElement = 0;
                if (j == 0 || j == lastLine.size()) {
                    currElement = 1;
                } else {
                    currElement = lastLine.get(j-1) + lastLine.get(j);
                }
                next.add(currElement);
            }
            result.add(next);
        }
        return result;
    }
}
