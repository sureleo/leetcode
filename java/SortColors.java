public class Solution {
    public void sortColors(int[] A) {
        int zero = this.moveZeroToLeft(A);
        this.moveTwoToRight(A, zero);
    }
    
    public void swap(int[] A, int slow, int fast) {
        int temp = A[slow];
        A[slow] = A[fast];
        A[fast] = temp;
    }
    
    public int moveZeroToLeft(int[] A) {
        int slow = 0;
        int fast = 0;
        while (fast < A.length) {
            if (A[fast] == 0) {
                this.swap(A, slow, fast);
                slow += 1;
            }
            fast += 1;
        }
        return slow;
    }
    
    public void moveTwoToRight(int[] A, int zero) {
        int slow = A.length - 1;
        int fast = A.length - 1;
        while (fast >= zero) {
            if (A[fast] == 2) {
                this.swap(A, slow, fast);
                slow -= 1;
            }
            fast -= 1;
        }
    }
}
