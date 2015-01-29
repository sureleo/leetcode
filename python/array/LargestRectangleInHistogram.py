class Solution:
    # @param height, a list of integer
    # @return an integer
    def largestRectangleArea(self, height):
        height.append(0)
        result = 0
        stack = []
        i = 0
        while i < len(height):
            if len(stack) == 0 or height[stack[-1]] <= height[i]:
                stack.append(i)
                i += 1
            else:
                length = height[stack[-1]]
                stack.pop()
                if len(stack) > 0:
                    width = i - stack[-1] - 1
                else:
                    width = i
                result = max(length * width, result)
        return result

if __name__ == "__main__":
    solution = Solution()

    print solution.largestRectangleArea([1])
