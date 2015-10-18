class Solution:
    # @param board, a list of lists of 1 length string
    # @param word, a string
    # @return a boolean
    def __init__(self):
        self.word = ""
        self.board = []
        self.rows = 0
        self.cols = 0
        self.result = False
        
    def exist(self, board, word):
        self.board = board
        self.rows = len(board)
        self.cols = len(board[0])
        self.word = word
        for i in xrange(self.rows):
            for j in xrange(self.cols):
                if board[i][j] == word[0]:
                    self.dfs(i, j, word[1:])
        return self.result
        
    def dfs(self, i, j, word):
        if self.result:
            return
        if len(word) == 0:
            self.result = True
            return True
        if not self.result:
            temp = self.board[i][j]
            self.board[i][j] = '.'
            up = i - 1
            down = i + 1
            left = j - 1
            right = j + 1
            if up >= 0 and self.board[up][j] == word[0]:
                self.dfs(up, j, word[1:])
            if down <= self.rows - 1 and self.board[down][j] == word[0]:
                self.dfs(down, j, word[1:])
            if left >= 0 and self.board[i][left] == word[0]:
                self.dfs(i, left, word[1:])
            if right <= self.cols - 1 and self.board[i][right] == word[0]:
                self.dfs(i, right, word[1:])
            self.board[i][j] = temp

if __name__ == "__main__":
    solution = Solution()

    print solution.exist(['a', 'a'], "aaa")
