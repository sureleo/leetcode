class Solution:
    # @param board, a 2D array
    # Capture all regions by modifying the input board in-place.
    # Do not return any value.
    def __init__(self):
        self.queue = []
        self.board = []
        
    def deal_edge(self):
        rows = len(self.board)
        cols = len(self.board[0])
        for i in xrange(rows):
            if self.board[i][0] == 'O':
                self.queue.append((i, 0))
            if self.board[i][cols-1] == 'O' and cols-1 > 0:
                self.queue.append((i, cols-1))
        for i in xrange(1, cols-1):
            if self.board[0][i] == 'O':
                self.queue.append((0, i))
            if self.board[rows-1][i] == 'O' and rows-1 > 0:
                self.queue.append((rows-1, i))
        
    def solve(self, board):
        self.board = board

        rows = len(self.board)
        if rows == 0 or rows == 1:
            return board

        self.deal_edge()
        self.bfs()
        rows = len(board)
        cols = len(board[0])
        for i in xrange(rows):
            for j in xrange(cols):
                if board[i][j] == 'O':
                    board[i][j] = 'X'
                if board[i][j] == '#':
                    board[i][j] = 'O'
        
    def bfs(self):
        while len(self.queue) > 0:
            curr = self.queue.pop()
            row = curr[0]
            col = curr[1]
            self.board[row][col] = '#'
            self.fill(row-1, col)
            self.fill(row+1, col)
            self.fill(row, col-1)
            self.fill(row, col+1)
        
    def fill(self, row, col):
        rows = len(self.board)
        cols = len(self.board[0])
        if row < 0 or col < 0 or row >= rows or col >= cols or self.board[row][col] != 'O':
            return
        else:
            self.queue.append((row, col))
        
if __name__ == "__main__":
    solution = Solution()

    print solution.solve([])
    print solution.solve([['O', 'O'], ['O', 'O']])
