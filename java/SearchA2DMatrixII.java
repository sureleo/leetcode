public class BinarySearchSolution {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean result = false;
        for (int i = 0; i < matrix.length; i++) {
            result |= binarySearch(matrix[i], target);
        }
        
        return result;
    }
    
    public boolean binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        
        while (low <= high) {
            int mid = low + (high-low) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return false;
    }
}

public class LinearSolution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        if (rows == 0) {
            return false;
        }
        
        int cols = matrix[0].length - 1;
        for (int i = 0; i < rows; i++) {
            while (cols > 0 && matrix[i][cols] > target) {
                cols -= 1;
            }
            
            if (matrix[i][cols] == target) {
                return true;
            }
        }
        
        return false;
    }
}

public class DivideAndConquerSolution {
    public int[][] matrix;
    public int target = 0;
    
    public boolean searchMatrix(int[][] matrix, int target) {
        this.matrix = matrix;
        this.target = target;
        int rows = this.matrix.length;
        if (rows == 0) {
            return false;
        }
        
        int cols = this.matrix[0].length;
        return this.eliminateQuarter(0, rows-1, 0, cols-1);
    }
    
    public boolean eliminateQuarter(int rs, int re, int cs, int ce) {
        if (rs > re || cs > ce) {
            return false;
        }
        
        int rm = rs + (re-rs) / 2;
        int cm = cs + (ce-cs) / 2;
        if (this.matrix[rm][cm] == this.target) {
            return true;
        } else if (this.matrix[rm][cm] < target) {
            return eliminateQuarter(rs, rm, cm+1, ce) || eliminateQuarter(rm+1, re, cs, ce);
        } else {
            return eliminateQuarter(rs, rm-1, cs, ce) || eliminateQuarter(rm, re, cs, cm-1);
        }
    }
}
