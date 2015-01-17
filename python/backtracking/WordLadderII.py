class Solution:
    # @param start, a string
    # @param end, a string
    # @param dict, a set of string
    # @return a list of lists of string
    # @remark prevMap = {cog:[log, dog], log:[lot], dog:[dot], lot:[hot], hot:[hit]}
    def __init__(self):
        self.prevMap = {}
        self.result = []
        self.start = ""
        self.end = ""

    def buildPath(self, valuelist, end):
        if end == self.start:
            valuelist.append(end)
            valuelist.reverse()
            self.result.append(valuelist)
            return
        for i in xrange(len(self.prevMap[end])):
            self.buildPath(valuelist+[end], self.prevMap[end][i])
        
    def findLadders(self, start, end, dict):
        self.start = start
        self.end = end
        dict.add(start)
        dict.add(end)
        wordLength = len(start)
        previous = set()
        current = set()
        current.add(start)
        while True:
            previous = current
            current = set()
            for word in previous:
                for k in xrange(wordLength):
                    for j in "abcdefghijklmnopqrstuvwxyz":
                        new_word = word[:k] + j + word[k+1:]
                        if new_word != word and new_word in dict and new_word not in previous:
                            current.add(new_word)
                            if new_word not in self.prevMap:
                                self.prevMap[new_word] = [word]
                            else:
                                self.prevMap[new_word].append(word)
                dict.remove(word)

            if end in current:
                break
            if len(current) == 0:
                return []

        self.buildPath([], self.end)
        return self.result

if __name__ == "__main__":
    solution = Solution()

    #print solution.findLadders("hit", "cog", {"hot", "dot", "dog", "lot", "log"})
    print solution.findLadders("hot", "dog", {"hot", "dog"})
