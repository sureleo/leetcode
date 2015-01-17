class Solution:
    # @return a boolean
    def isValid(self, s):
        d = {"(":")", "[":"]", "{":"}"}
        stack = []
        for i in xrange(len(s)):
            if s[i] == "(" or s[i] == "[" or  s[i] == "{":
                stack.append(s[i])
            else:
                if len(stack) == 0:
                    return False
                else:
                    last = stack[-1]
                    if s[i] != d[last]:
                        return False
                    else:
                        stack.pop()
        
        if len(stack) == 0:
            return True
        return False
                
if __name__ == "__main__":
    solution = Solution()
    print solution.isValid("]")
 
