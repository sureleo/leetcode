class Solution:
    # @return a list of lists of integer
    def generateMatrix(self, n):
        result = [[0 for i in xrange(n)] for i in xrange(n)]
        i = 0
        rows = n
        cols = n
        startRow = 0
        startCol = 0
        direction = 0
        col = 0
        row = 0
        while i < n * n:
            i += 1
            result[row][col] = i
            if direction == 0:
                if col == cols - 1:
                    row += 1
                    direction = 1
                else:
                    col += 1
            elif direction == 1:
                if row == rows - 1:
                    col -= 1
                    direction = 2
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

    print solution.generateMatrix(3)
