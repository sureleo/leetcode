public class Solution {
    public boolean isUgly(int num) {
        int afterTwo = check(num, 2);
        int afterThree = check(afterTwo, 3);
        return check(afterThree, 5) == 1;
    }
    
    public int check(int num, int i) {
        while (num > 1) {
            if (num % i != 0) {
                return num;
            }
            
            num = num / i; 
        }
        
        return num;
    }
}
