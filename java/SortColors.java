public class TwoPassSolution {
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

// My previous solution is actually two passes.
// Here's one pass solution from:
// http://fisherlei.blogspot.com/2013/01/leetcode-sort-colors.html
public class OnePassSolution {
    public void sortColors(int[] nums) {
        int red = 0;
        int blue = nums.length - 1;
        int i = 0;
        while (i < blue + 1) {
            if (nums[i] == 1) {
                i ++;
            } else if (nums[i] == 2) {
                swap(nums, i, blue);
                blue --;
            } else {
                swap(nums, i, red);
                red ++;
                i ++;
            }
        }
    }
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
