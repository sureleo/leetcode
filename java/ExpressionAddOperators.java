public class Solution {
    public int target = 0;
    public List<String> result = new ArrayList<String>();

    public List<String> addOperators(String num, int target) {
        this.target = target;
        dfs(num, "", 0, 0);
        return this.result;
    }

    public void dfs(String num, String curr, long currSum, long prevSum) {
        if (num.length() == 0 && currSum == this.target) {
            result.add(curr);
            return;
        }

        if (num.length() == 0) {
            return;
        }

        for (int i = 1; i <= num.length(); i++) {
            String left = num.substring(0, i);
            String right = num.substring(i, num.length());
            if (left.length() > 1 && left.charAt(0) == '0') {
                return;
            }

            long currNum = Long.parseLong(left);
            if (curr.length() == 0) {
                dfs(right, left, currNum, currNum);
            } else {
                dfs(right, curr + "+" + left, currSum + currNum, currNum);
                dfs(right, curr + "-" + left, currSum - currNum, -currNum);
                dfs(right, curr + "*" + left, currSum - prevSum + currNum * prevSum, prevSum * currNum);
            }
        }
    }
}
