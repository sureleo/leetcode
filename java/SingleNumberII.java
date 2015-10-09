// http://blog.csdn.net/linhuanmars/article/details/22645599
// This is a better method for understanding. 
// TODO: Check how negation works in terms of Bitwise
public class Solution {
    public int singleNumber(int[] nums) {
        int[] digit = new int[32];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 32; j++) {
                digit[j] += (nums[i] >> j) & 1;
            }
        }
        
        for (int i = 0; i < 32; i++) {
            res += (digit[i] % 3) << i;
        }
        
        return res;
    }
}
