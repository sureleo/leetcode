public class Solution {
    public int majorityElementDivideAndConquer(int[] num) {
        if (num.length == 1 || num.length == 2) {
            return num[0];
        }
        
        int left = majorityElement(Arrays.copyOfRange(num, 0, (num.length-1)/2+1));
        int right = majorityElement(Arrays.copyOfRange(num, (num.length-1)/2+1, num.length));
        
        int leftCount = 0;
        int rightCount = 0;
        for (int i = 0; i < num.length; i++) {
            if (num[i] == left) {
                leftCount += 1;
            }
            if (num[i] == right) {
                rightCount += 1;
            }
        }
        if (leftCount > rightCount) {
            return left;
        } else {
            return right;
        }
    }
}
