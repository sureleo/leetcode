class Solution:
    # @param s, a string
    # @return an integer
    def numDecodings(self, s):
        if len(s) == 0 or s[0] == "0":
            return 0
            
        opt = [0 for i in xrange(len(s)+1)]
        opt[0] = 1
        opt[1] = 1
        
        for i in xrange(2, len(s)+1):
            temp = int(s[i-2:i])
            if temp == 10 or temp == 20:
                opt[i] = opt[i-2]
            elif (temp >= 11 and temp <= 19) or (temp >= 21 and temp <= 26):
                opt[i] = opt[i-1] + opt[i-2]
            elif temp % 10 != 0:
                opt[i] = opt[i-1]
            else:
                opt[i] = 0
                
        return opt[len(s)]

if __name__ == "__main__":
    solution = Solution()

    print solution.numDecodings("12")
