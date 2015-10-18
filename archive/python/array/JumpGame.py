class Solution:
    # @param A, a list of integers
    # @return a boolean
    def canJump(self, A):
        if len(A) == 0 or len(A) == 1:
            return True
            
        i = 1
        maxCanReach = A[0]
        while i < maxCanReach + 1:
            maxCanReach = max(A[i]+i, maxCanReach)
            if maxCanReach >= len(A) - 1:
                return True
            i += 1

        return False


if __name__ == "__main__":
    solution = Solution()

    print solution.canJump([1, 1, 1, 0])
