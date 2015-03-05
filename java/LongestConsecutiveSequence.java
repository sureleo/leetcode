public class Solution {
    public int longestConsecutive(int[] num) {
        int result = 1;
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i< num.length; i++) {
            if (set.contains(num[i]) == false) {
                set.add(num[i]);
            }
        }
        for (int i = 0; i < num.length; i++) {
            if (set.contains(num[i])) {
                int left = num[i] - 1;
                int right = num[i] + 1;
                while (set.contains(left) == true) {
                    set.remove(left);
                    left --;
                }
                while (set.contains(right) == true) {
                    set.remove(right);
                    right ++;
                }
                set.remove(num[i]);
                result = Math.max(result, right-left-1);
            }
        }
        return result;
    }
}
