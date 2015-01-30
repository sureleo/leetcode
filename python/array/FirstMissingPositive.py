class Solution:
    # @param A, a list of integers
    # @return an integer
    def firstMissingPositive(self, A):
        i = 0
        while i < len(A):
            """
            The last condition is used to deal with the second test case.
            i = 3, A[i] = 2
            A[i]-1 = 1
            A[A[i]-1] = 2
            we should skip this one. as well as i = 4
            """
            if i + 1 == A[i] or A[i] > len(A) or A[i] <= 0 or A[A[i]-1] == A[i]:
                i += 1
            else:
                temp = A[i]
                target = A[i] - 1
                A[i] = A[target]
                A[target] = temp
            

        meet_one = False
        for i in xrange(len(A)):
            if not meet_one and A[i] == 1:
                meet_one = True
            if meet_one and A[i] != i+1:
                return i+1

        if not meet_one:
            return 1

        return len(A) + 1

if __name__ == "__main__":
    solution = Solution()

    #print solution.firstMissingPositive([2, 3, 5, 1])
    print solution.firstMissingPositive([1, 2, 2, 2])
