import java.util.Arrays;
public class Solution {
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int min_diff = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < num.length-2; i++) {
            int left = i + 1;
            int right = num.length - 1;
            while (left < right) {
                int curr = num[i] + num[left] + num[right];
                if (curr == target) {
                    return target;
                } else if (curr > target) {
                    right --;
                } else {
                    left ++;
                }
                if (Math.abs(curr-target) < min_diff) {
                    min_diff = Math.abs(curr-target);
                    result = curr;
                } 
            }
        }
        return result;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        int num[] = new int[] {1, 1, 1, 0};
        System.out.println(s.threeSumClosest(num, 100));
    }
}
