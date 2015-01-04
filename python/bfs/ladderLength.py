class Solution:
    # @param start, a string
    # @param end, a string
    # @param dict, a set of string
    # @return an integer
    def __init__(self):
        self.dict = {}
        self.start = ""
        self.end = ""
        self.queue = []

    def ladderLength(self, start, end, dict):
        self.start = start
        self.end = end
        dict.add(self.end)
        self.dict = dict
        self.queue.append((start, 1))
        while len(self.queue) > 0:
            curr = self.queue.pop(0)
            if curr[0] == self.end:
                return curr[1]
            self.substitute(curr)

        return 0

    def substitute(self, curr):
        currWord = curr[0]
        currLength = curr[1]
        for i in xrange(len(currWord)):
            for j in "abcdefghijklmnopqrstuvwxyz":
                new_word = currWord[:i] + j + currWord[i+1:]
                if new_word in self.dict and new_word != currWord:
                    self.queue.append((new_word, currLength+1))
                    self.dict.remove(new_word)

if __name__ == "__main__":
    solution = Solution()

    #print solution.ladderLength("hot", "dog", {"hot", "dog"})
    print solution.ladderLength("hit", "cog", {"hot", "dot", "dog", "lot", "log"})
