class Solution:
    # @param board, a 9x9 2D array
    # Solve the Sudoku by modifying the input board in-place.
    # Do not return any value.
    def solveSudoku(self, board):
        for i in xrange(len(board)):
            board[i] = list(board[i])
        self.dfs(0, 0, board)
        for i in xrange(len(board)):
            board[i] = "".join(board[i])

    def dfs(self, i, j, board):
        if j >= 9:
            return self.dfs(i+1, 0, board)
        if i == 9:
            return True
        if board[i][j] != ".":
            return self.dfs(i, j+1, board)
        else:
            for k in xrange(1, 10):
                board[i][j] = str(k)
                if self.check(i, j, board):
                    if self.dfs(i, j+1, board):
                        return True
                board[i][j] = "."
        return False
    
    def check(self, i, j, board):
        for m in xrange(9):
            if j != m and board[i][m] == board[i][j]:
                return False
        for m in xrange(9):
            if i != m and board[m][j] == board[i][j]:
                return False
        tempi = i/3*3
        tempj = j/3*3
        for m in xrange(tempi, tempi+3):
            for n in xrange(tempj, tempj+3):
                if (m != i or n != j) and board[m][n] == board[i][j]:
                    return False
        return True

if __name__ == "__main__":
    solution = Solution()

    solution.solveSudoku([
        "..9748...",
        "7........",
        ".2.1.9...",
        "..7...24.",
        ".64.1.59.",
        ".98...3..",
        "...8.3.2.",
        "........6",
        "...2759.."
    ])
