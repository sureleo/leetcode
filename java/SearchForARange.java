//this can be refactored. but i'm head to lunch. XD
public class Solution {
    public int[] searchRange(int[] A, int target) {
        int[] result = new int[2];
        int exist = checkExist(A, target);
        if (exist == -1) {
            result[0] = -1;
            result[1] = -1;
            return result;
        }
        result[0] = this.searchLeft(A, 0, exist);
        result[1] = this.searchRight(A, exist, A.length-1);
        return result;
    }
    
    public int searchLeft(int[] A, int left, int right) {
        int target = A[right];
        while(left <= right) {
            int mid = (left + right) / 2;
            if ((mid == 0 || A[mid-1] != target) && A[mid] == target) {
                return mid;
            }
            if (A[mid] != target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
    
    public int searchRight(int[] A, int left, int right) {
        int target = A[left];
        int mid = (left + right) / 2;
        if ((mid == A.length - 1 || A[mid+1] != target) && A[mid] == target) {
            return mid;
        }
        if (A[mid] != target) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
        return left;
    }
    
    public int checkExist(int[] A, int target) {
        int left = 0;
        int right = A.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
