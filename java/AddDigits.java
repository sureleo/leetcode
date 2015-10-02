public class Solution {
    public int addDigits(int num) {
        if (num < 10) {
            return num;
        }
        
        int result = 0;
        while (num > 0) {
            result += num % 10;
            num = num / 10;
        }
        
        return addDigits(result);
    }
}

// not a good practice during an interview
public class MathSolution {
    public int addDigits(int num) {
        return (1 + (num-1) % 9);
    }
}
