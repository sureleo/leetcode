#first thinking was like atoi. However, that will make this problem really complicated.
#http://www.cnblogs.com/huntfor/p/3915882.html
#the above thinking is better than mine.
#additional condition to judge "+3e" ".3E"
class Solution:
    # @param s, a string
    # @return a boolean
    def isNumber(self, s):
        hasE = False
        operatorCount = 0
        hasDot = False
        hasNum = False

        others = set()
        others.add("+")
        others.add("-")
        others.add(".")
        others.add("e")
        others.add("E")

        s = s.strip()
        if len(s) == 0:
            return False
        for i in xrange(len(s)):
            if not s[i].isdigit() and s[i] not in others:
                return False
            if s[i].isdigit():
                hasNum = True
            if s[i] == "e" or s[i] == "E":
                if i == 0 or i == (len(s)-1):
                    return False
                if hasE or (i-1 == 0 and (s[i-1] == "." or s[i-1] == "+" or s[i-1] == "-")):
                    return False
                else:
                    hasE = True
            if s[i] == ".":
                if i == 0 and len(s) == 1:
                    return False
                if i == len(s) - 1 and not hasNum:
                    return False
                if not hasDot and not hasE:
                    hasDot = True
                else:
                    return False
            if s[i] == "+" or s[i] == "-":
                if i == len(s) - 1 or (i != 0 and (s[i-1] != "e" and s[i-1] != "E")):
                    return False
                if operatorCount == 2:
                    return False
                if operatorCount == 1 and not hasE and not hasNum:
                    return False
                operatorCount += 1

        return True


if __name__ == "__main__":
    solution = Solution()
    #print solution.isNumber("3.")
    #print solution.isNumber(".e1")
    #print solution.isNumber("+E3")
    #print solution.isNumber("46.e3")
    print solution.isNumber(" 005047e+6")
