class Solution:
    # @param num, a list of integer
    # @return an integer
    def findPeakElement(self, num):
        INT_MIN = -2147483648
        num.insert(0, INT_MIN)
        num.append(INT_MIN)
        
        low = 0
        high = len(num) - 1
        while low <= high:
            mid = (low + high) / 2
            if num[mid] > num[mid-1] and num[mid] > num[mid+1]:
                return mid - 1
            elif num[mid-1] > num[mid]:
                high = mid - 1
            else:
                low = mid + 1

if __name__ == "__main__":
    solution = Solution()
    A = [-2147483648]
    print solution.findPeakElement(A)
