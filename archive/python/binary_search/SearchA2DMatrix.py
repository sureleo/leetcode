class Solution:
    # @param matrix, a list of lists of integers
    # @param target, an integer
    # @return a boolean
    def searchMatrix(self, matrix, target):
        rows = len(matrix)
        
        low_rows = 0
        high_rows = len(matrix) - 1
        row_search = -1
        
        while low_rows <= high_rows:
            mid = (low_rows + high_rows) / 2
            if matrix[mid][0] > target:
                high_rows = mid - 1
            elif matrix[mid][0] < target:
                if (mid + 1) == len(matrix) or matrix[mid+1][0] > target:
                    row_search = mid
                    break
                else:
                    low_rows = mid + 1
            else:
                return True
                
        if row_search == -1:
            return False
            
        low = 0
        high = len(matrix[0]) - 1
        while low <= high:
            mid = (low + high) / 2
            if matrix[row_search][mid] > target:
                high = mid - 1
            elif matrix[row_search][mid] < target:
                low = mid + 1
            else:
                return True
        return False

if __name__ == "__main__":
    solution = Solution()
    print solution.searchMatrix([[1]], 0)
    print solution.searchMatrix([[1], [3]], 3)
