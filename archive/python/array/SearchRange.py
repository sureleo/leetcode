class Solution:
    # @param A, a list of integers
    # @param target, an integer to be searched
    # @return a list of length 2, [index1, index2]
    def searchRange(self, A, target):
        exist = self.checkExists(A, target)
        if exist == -1:
            return [-1, -1]
        else:
            return [self.searchLeft(A, exist, target), self.searchRight(A, exist, target)]
    
    def checkExists(self, A, target):
        low = 0
        high = len(A) - 1
        while low <= high:
            mid = (low+high) / 2
            if A[mid] == target:
                return mid
            if A[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1
    
    def searchLeft(self, A, mid, target):
        low = 0
        high = mid
        while low <= high:
            mid = (low + high) / 2
            if A[mid] == target:
                high = mid - 1
            else:
                if A[mid+1] == target:
                    return mid + 1
                else:
                    low = mid + 1
        return low
    
    def searchRight(self, A, mid, target):
        high = len(A) - 1
        low = mid
        while low <= high:
            mid = (low + high) / 2
            if A[mid] == target:
                low = mid + 1
            else:
                if A[mid-1] == target:
                    return mid - 1
                else:
                    high = mid - 1
        return high

if __name__ == "__main__":
    solution = Solution()

    print solution.searchRange([1, 4], 4)
    print solution.searchRange([1, 4], 4)
