// https://leetcode.com/problems/single-number-iii/
// -x is compliment of x; ~x is negation of x

public class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = nums[0];
        int a = 0;
        int b = 0;
        for (int i = 1; i < nums.length; i++) {
            xor = nums[i] ^ xor;
        }

        int lowbit = xor & (-xor);
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & lowbit) != 0) {
                a ^= nums[i];
            } else {
                b ^= nums[i];
            }
        }

        int[] result = {a, b};
        return result;
    }
}
