class Solution:
    # @param A a list of integers
    # @param target an integer
    # @return a boolean
    def search(self, A, target):
        low = 0
        high = len(A) - 1
        while low <= high:
            mid = (low+high) / 2
            if A[mid] == target:
                return True
            if A[mid] >= A[low]:
                if A[mid] == A[low]:
                    #Note here, time complexity changed to O(n)
                    low += 1
                    continue
                if target >= A[low] and target < A[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
            else:
                if target > A[mid] and target <= A[high]:
                    low = mid + 1
                else:
                    high = mid - 1
        return False

if __name__ == "__main__":
    solution = Solution()

    #print solution.threeSumClosest([-3, -2, -5, 3, -4], -1)
    print solution.search([1, 3, 1, 1, 1], 3)
