// http://www.cnblogs.com/grandyang/p/4431646.html
// bit manipulations are tricky
public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int d = Integer.MAX_VALUE;
        while ((m & d) != (n & d)) {
            d <<= 1;
        }
        
        return m & d;
    }
}
