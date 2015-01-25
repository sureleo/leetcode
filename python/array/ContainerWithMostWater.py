class Solution:
    # @return an integer
    def maxArea(self, height):
        low = 0
        high = len(height) - 1
        maxWater = 0
        while low < high:
            currLength = high - low
            currHeight = min(height[high], height[low])
            maxWater = max(currLength*currHeight, maxWater)
            if height[low] < height[low+1]:
                low += 1
            elif height[high] < height[high-1]:
                high -= 1
            else:
                if height[low] > height[high]:
                    high -= 1
                else:
                    low += 1
        return maxWater

if __name__ == "__main__":
    solution = Solution()

    print solution.maxArea([5, 2, 42, 1, 5, 30, 4, 11, 9, 4])
