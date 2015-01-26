class Solution:
    # @param A, a list of integers
    # @param target, an integer to be inserted
    # @return integer
    def searchInsert(self, A, target):
        low = 0
        high = len(A) - 1
        while low <= high:
            mid = (low + high) / 2
            if target == A[mid]:
                return mid
            if target > A[mid]:
                low = mid + 1
            else:
                high = mid - 1
        
        if target >= A[mid]:
            return mid + 1
        else:
            return mid
