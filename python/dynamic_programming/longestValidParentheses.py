class Solution:
    # @param s, a string
    # @return an integer
    def longestValidParentheses(self, s):
        stack = []
        result = [-1 for i in xrange(len(s))]
        counter = 0
        maximum = 0
        curr = 0
        
        for i in xrange(len(s)):
            if s[i] == "(":
                stack.append(i)
            else:
                if len(stack) == 0:
                    result = max(counter, result)
                else:
                    j = stack.pop()
                    result[j] = j
                    result[i] = i

        for i in xrange(len(result)):
            if result[i] == i:
                curr += 1
            else:
                maximum = max(maximum, curr)
                curr = 0

        return max(curr, maximum)

if __name__ == "__main__":
    solution = Solution()

    print solution.longestValidParentheses("()")
    #print solution.longestValidParentheses("()(()")
