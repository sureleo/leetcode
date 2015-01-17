class Solution:
    # @param s, a string
    # @return an integer
    def titleToNumber(self, s):
        d = {
            'A':0, 'B':1, 'C':2, 'D':3, 'E':4,
            'F':5, 'G':6, 'H':7, 'I':8, 'J':9,
            'K':10, 'L':11, 'M':12, 'N':13, 'O':14,
            'P':15, 'Q':16, 'R':17, 'S':18, 'T':19,
            'U':20, 'V':21, 'W':22, 'X':23, 'Y':24, 'Z':25
        }
        
        result = 0
        
        for i in xrange(len(s)-1, -1, -1):
            result += (d[s[i]]+1) * (26**(len(s)-i-1))
            
        return result


if __name__ == "__main__":
    solution = Solution()
    print solution.titleToNumber("BA")
    print solution.titleToNumber("AB")
