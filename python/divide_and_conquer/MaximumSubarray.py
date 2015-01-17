class Solution:
    # @param A, a list of integers
    # @return an integer
    def __init__(self):
        self.INT_MIN = -2147483648
        
    def maxSubArray(self, A):
        if len(A) == 1:
            return A[0]
            
        left_half = self.maxSubArray(A[:len(A)/2])
        right_half = self.maxSubArray(A[len(A)/2:])
        
        maxLeftHalf = self.INT_MIN
        leftHalf = 0
        for i in xrange(len(A)/2-1, -1, -1):
            leftHalf += A[i]
            maxLeftHalf = max(leftHalf, maxLeftHalf)
        
        maxRightHalf = self.INT_MIN
        rightHalf = 0
        for i in xrange(len(A)/2, len(A)):
            rightHalf += A[i]
            maxRightHalf = max(rightHalf, maxRightHalf)
        
        return max([left_half, right_half, maxLeftHalf+maxRightHalf])
