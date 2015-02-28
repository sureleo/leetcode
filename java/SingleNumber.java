public class Solution {
    public int singleNumber(int[] A) {
        int result = 0;
        for (int a : A) {
            result = a ^ result;
        }
        return result;
    }
}
