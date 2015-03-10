public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>();
        List<Integer> next = new ArrayList<Integer>();
        result.add(1);
        int i = 0;
        while (i < rowIndex) {
            for (int j = 0; j <= result.size(); j++) {
                int currElement = 0;
                if (j == 0 || j == result.size()) {
                    currElement = 1;
                } else {
                    currElement = result.get(j-1) + result.get(j);
                }
                next.add(currElement);
            }
            result = new ArrayList(next);
            next = new ArrayList();
            i += 1;
        }
        return result;
    }
}
