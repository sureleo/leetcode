public class Solution {
    public int reverse(int x) {
        int result = 0;
        int negative = 1;
        if (x < 0) {
            x = 0 - x;
            negative = -1;
        }
        while (x > 0) {
            int curr = x % 10;
            x = x / 10;
            result = result * 10 + curr;
            if (result != 0 && ((Integer.MAX_VALUE / result) < 10 && x != 0)) {
                return 0;
            }
        }
        return negative * result;
    }
}
