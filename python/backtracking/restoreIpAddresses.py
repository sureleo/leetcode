class Solution:
    # @param s, a string
    # @return a list of strings
    def __init__(self):
        self.result = []
        self.ip = ""
    
    def restoreIpAddresses(self, s):
        self.ip = s
        if len(self.ip) < 4:
            return self.result
        if len(self.ip) > 12:
            return self.result

        self.dfs(0, [])
        return self.result
        
    def dfs(self, start, valuelist):
        if len(self.ip) - len("".join(valuelist)) > 3 * (4 - len(valuelist)):
            return 
        if len(valuelist) > 0 and not self.checkValid(valuelist[-1]):
            return
        if len(valuelist) == 4:
            valuelist = ".".join(valuelist)
            if len(self.ip) + 3 == len(valuelist) and valuelist not in self.result:
                self.result.append(valuelist)
            return
        for i in xrange(start, len(self.ip)):
            for j in xrange(3):
                self.dfs(i+j+1, valuelist+[self.ip[i:i+j+1]])
                if self.ip[i] == "0":
                    break

    def checkValid(self, segment):
        if len(segment) == 0:
            return False
        if len(segment) > 1 and segment[0] == "0":
            return False
        if len(segment) > 3:
            return False
        if int(segment) > 255:
            return False
        return True

if __name__ == "__main__":
    solution = Solution()

    #print solution.restoreIpAddresses("25525511135")
    print solution.restoreIpAddresses("652811844282")
