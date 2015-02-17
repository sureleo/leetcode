public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        for (int i = 0; i < num.length-2; i++) {
            if (i != 0 && num[i] == num[i-1]) {
                continue;
            }
            int left = i + 1;
            int right = num.length - 1;
            while (left < right) {
                Boolean shrinkRight = false;
                Boolean shrinkLeft = false;
                int sum = num[i] + num[left] + num[right];
                if (sum == 0) {
                    List<Integer> curr = new ArrayList<Integer>();
                    curr.add(num[i]);
                    curr.add(num[left]);
                    curr.add(num[right]);
                    result.add(curr);
                    shrinkLeft = true;
                    shrinkRight = true;
                } else if (sum > 0) {
                    shrinkRight = true;
                } else {
                    shrinkLeft = true;
                }
                if (shrinkLeft == true) {
                    int temp_left = left;
                    while (left < num.length && num[left] == num[temp_left]) {
                        left += 1;
                    }
                }
                if (shrinkRight == true) {
                    int temp_right = right;
                    while (right >= 0 && num[right] == num[temp_right]) {
                        right -= 1;
                    }
                }
            }
        }
        return result;
    }
}
