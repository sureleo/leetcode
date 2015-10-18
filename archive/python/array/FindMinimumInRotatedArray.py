class Solution:
    # @param num, a list of integer
    # @return an integer
    def findMin(self, num):
        low = 0
        high = len(num) - 1
        while low < high - 1:
            mid = (low + high) / 2
            if num[mid] > num[high]:
                low = mid
            else:
                high = mid
                
        return min(num[low], num[high])
