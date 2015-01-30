class Solution:
    # @param matrix, a list of lists of 1 length string
    # @return an integer
    def maximalRectangle(self, matrix):
        result = 0
        if len(matrix) == 0:
            return result
            
        height = [0 for i in xrange(len(matrix[0]))]
        for i in xrange(len(matrix)):
            for j in xrange(len(matrix[0])):
                if int(matrix[i][j]) == 0:
                    height[j] = 0
                else:
                    height[j] += 1
            
            curr_max = self.doHistogram(height + [0])
            result = max(curr_max, result)
        return result
    
    def doHistogram(self, A):
        i = 0
        result = 0
        stack = []
        while i < len(A):
            if len(stack) == 0 or A[i] > A[stack[-1]]:
                stack.append(i)
                i += 1
            else:
                length = A[stack[-1]]
                stack.pop()
                width = 0
                if len(stack) == 0:
                    width = i
                else:
                    width = i - stack[-1] - 1
                result = max(width * length, result)
        return result

if __name__ == "__main__":
    solution = Solution()

    print solution.maximalRectangle(["0"])
