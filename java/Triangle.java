public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] opt = new int[triangle.get(triangle.size()-1).size()];
        Arrays.fill(opt, 0);
        int[] opt_temp = Arrays.copyOfRange(opt, 0, opt.length);
        for (int i = 0; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int left = opt[j] + triangle.get(i).get(j);
                int right = 0;
                if (j > 0) {
                    right = opt[j-1] + triangle.get(i).get(j);
                }
                if (j == 0) {
                    opt_temp[j] = left;
                } else if (j == triangle.get(i).size()-1) {
                    opt_temp[j] = right;
                } else {
                    opt_temp[j] = Math.min(left, right);
                }
            }
            opt = Arrays.copyOfRange(opt_temp, 0, opt_temp.length);
        }
        int result = 0;
        for (int i = 0; i < opt.length; i++) {
            if (i == 0 || opt[i] < result) {
                result = opt[i];
            }
        }
        return result;
    }
}
