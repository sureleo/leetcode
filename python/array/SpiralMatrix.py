class Solution:
    # @param matrix, a list of lists of integers
    # @return a list of integers
    def spiralOrder(self, matrix):
        rows = len(matrix)
        if rows == 0:
            return []
        cols = len(matrix[0])
        total = rows * cols
        direction = 0
        col = 0
        row = 0
        i = 0
        startRow = 0
        startCol = 0
        result = []
        while i < total:
            i += 1
            result.append(matrix[row][col])
            if direction == 0:
                if col == cols - 1:
                    direction = 1
                    row += 1
                else:
                    col += 1
            elif direction == 1:
                if row == rows - 1:
                    direction = 2
                    col -= 1
                else:
                    row += 1
            elif direction == 2:
                if col == startCol:
                    row -= 1
                    direction = 3
                else:
                    col -= 1
            else:
                if row == startRow + 1:
                    startRow += 1
                    startCol += 1
                    cols -= 1
                    rows -= 1
                    col += 1
                    direction = 0
                else:
                    row -= 1
                    
        return result
                

if __name__ == "__main__":
    solution = Solution()

    print solution.spiralOrder([[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12], [13, 14, 15, 16]])
