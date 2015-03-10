//when programming in java, you have to notice abs(MIN_VALUE) might cause overflow
//I don't want to use Long to solve it.
public class Solution {
    public int divide(int dividend, int divisor) {
        int negative = 1;
        int result = 0;
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1) {
                return Integer.MAX_VALUE;   
            }
            if (divisor == Integer.MIN_VALUE) {
                return 1;
            }
            dividend += Math.abs(divisor);
            result += 1;
        }
        
        if (divisor == Integer.MIN_VALUE) {
            return 0;
        }
        if (dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0) {
            negative = -1;
        }
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        
        int tempDivisor = divisor;
        int i = 1;
        while (dividend >= divisor) {
            while (dividend - tempDivisor >= tempDivisor) {
                tempDivisor = tempDivisor + tempDivisor;
                i = i + i;
            }
            dividend = dividend - tempDivisor;
            tempDivisor = divisor;
            result += i;
            i = 1;
        }
        return negative * result;
    }
}
