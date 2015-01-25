class Solution:
    # @param    A       a list of integers
    # @param    elem    an integer, value need to be removed
    # @return an integer
    def removeElement(self, A, elem):
        result = len(A)
        start = 0
        for i in xrange(len(A)):
            A[start] = A[i]
            if A[i] != elem:
                start += 1
            else:
                result -= 1
        return result
