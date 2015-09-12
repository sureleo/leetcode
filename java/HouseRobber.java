public class Solution {
    public int rob(int[] nums) {
        int opt[] = new int[nums.length + 1];
        opt[0] = 0;
        if (nums.length == 0) {
            return opt[0];
        }
        
        opt[1] = nums[0];
        for (int i = 2; i < opt.length; i++) {
            opt[i] = Math.max(opt[i-1], opt[i-2] + nums[i-1]);
        }
        
        return opt[nums.length];
    }
}
