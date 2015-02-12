public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        int high = matrix.length - 1;
        int row = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (matrix[mid][0] == target) {
                return true;
            }
            if ((mid == matrix.length - 1 || matrix[mid+1][0] > target) && matrix[mid][0] < target) {
                row = mid;
                break;
            }
            if (matrix[mid][0] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (row == -1) {
            return false;
        }
        low = 0;
        high = matrix[row].length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (matrix[row][mid] == target) {
                return true;
            }
            if (matrix[row][mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}
