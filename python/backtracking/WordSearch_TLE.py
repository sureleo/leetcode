class Solution:
    # @param board, a list of lists of 1 length string
    # @param word, a string
    # @return a boolean
    def __init__(self):
        self.board = []
        self.word = ""

    def exist(self, board, word):
        self.word = word
        if len(self.word) == 0:
            return True

        simple_board = []
        for i in xrange(len(board)):
            simple_board.append(list(board[i]))
        self.board = simple_board

        for i in xrange(len(self.board)):
            for j in xrange(len(self.board[0])):
                if self.board[i][j] == self.word[0]:
                    if self.dfs(i, j, self.word[0]):
                        return True
        return False

    def dfs(self, row, col, s):
        if len(s) == len(self.word):
            return True
        up = row-1
        down = row+1
        left = col-1
        right = col+1
        if up >= 0 and self.board[up][col] == self.word[len(s)]:
            temp = self.board[row][col]
            self.board[row][col] = "."
            if self.dfs(up, col, s+self.board[up][col]):
                return True
            self.board[row][col] = temp
        if down < len(self.board) and self.board[down][col] == self.word[len(s)]:
            temp = self.board[row][col]
            self.board[row][col] = "."
            if self.dfs(down, col, s+self.board[down][col]):
                return True
            self.board[row][col] = temp
        if left >= 0 and self.board[row][left] == self.word[len(s)]:
            temp = self.board[row][col]
            self.board[row][col] = "."
            if self.dfs(row, left, s+self.board[row][left]):
                return True
            self.board[row][col] = temp
        if right < len(self.board[0]) and self.board[row][right] == self.word[len(s)]:
            temp = self.board[row][col]
            self.board[row][col] = "."
            if self.dfs(row, right, s+self.board[row][right]):
                return True
            self.board[row][col] = temp

        return False

if __name__ == "__main__":
    solution = Solution()

    #print solution.exist([["a"]], "a")
    #print solution.exist(["ab", "cd"], "acdb")
    print solution.exist(["aaa", "aaa", "aab"], "aaaaaaaab")
    #print solution.exist(["ab"], "ba")
    #print solution.exist(["CAA", "AAA", "BCD"], "AAB")
    #import datetime
    #print datetime.datetime.now()
    #print solution.exist([
    #    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
    #    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
    #    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
    #    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
    #    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
    #    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
    #    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
    #    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
    #    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
    #    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
    #    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
    #    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
    #    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
    #    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
    #    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
    #    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
    #    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
    #    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
    #    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
    #    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
    #    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
    #    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
    #    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
    #    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
    #    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
    #    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
    #    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
    #    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
    #    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
    #    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaab"
    #    ],
    #    "baaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
    #)
    #import datetime
    #print datetime.datetime.now()
