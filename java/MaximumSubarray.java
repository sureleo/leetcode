public class Solution {
    public int maxSubArrayDP(int[] A) {
        int prev = A[0];
        int result = prev;
        for (int i = 1; i < A.length; i++) {
            int curr = Math.max(prev+A[i], A[i]);
            prev = curr;
            result = Math.max(result, curr);
        }
        return result;
    }

    public int maxSubArrayDivideConquer(int[] A) {
        if (A.length == 1) {
            return A[0];
        }
        int low = 0;
        int high = A.length - 1;
        int mid = (low + high) / 2;
        int left = maxSubArray(Arrays.copyOfRange(A, 0, mid+1));
        int right = maxSubArray(Arrays.copyOfRange(A, mid+1, A.length));
        int mid_left = Integer.MIN_VALUE;
        int mid_right = Integer.MIN_VALUE;
        int left_total = 0;
        int right_total = 0;
        for (int i = mid; i >= 0; i--) {
            left_total = left_total + A[i];
            mid_left = Math.max(mid_left, left_total);
        }
        for (int i = mid+1; i < A.length; i++) {
            right_total = right_total + A[i];
            mid_right = Math.max(mid_right, right_total);
        }
        return Math.max(left, Math.max(right, mid_left+mid_right));
    }
}
