class Solution:
    # @param a list of integers
    # @return an integer
    def removeDuplicates(self, A):
        result = len(A)
        if result == 0:
            return result
        
        curr = 0
        next_index = 1
        for i in xrange(1, len(A)):
            if A[i] > A[curr]:
                A[next_index] = A[i]
                curr = i
                next_index += 1
            else:
                result -= 1
        
        return result

if __name__ == "__main__":
    solution = Solution()
    A = [1, 1]
    result = solution.removeDuplicates(A)
    print A[:result]
