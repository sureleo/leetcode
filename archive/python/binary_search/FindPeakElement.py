#improvement: avoid of using list.insert()
#list.insert is O(n) which violate O(logn)
class Solution:
    # @param num, a list of integer
    # @return an integer
    def findPeakElement(self, num):
        INT_MIN = -2147483648

        low = 0
        high = len(num)
        if low == (high - 1):
            return low

        while low <= high:
            mid = (low + high) / 2
            if (mid == len(num) - 1) and num[mid] > num[mid-1]:
                return mid
            if (mid == 0) and num[mid] > num[mid+1]:
                return mid
            if num[mid] > num[mid-1] and num[mid] > num[mid+1]:
                return mid
            elif num[mid-1] > num[mid]:
                high = mid - 1
            else:
                low = mid + 1

if __name__ == "__main__":
    solution = Solution()
    A = [1, 2, 3]
    print solution.findPeakElement(A)
