#Solution from: http://blog.csdn.net/havenoidea/article/details/11853301
#use a variable temp to mark how far could we jump so far.
#didn't quite think of that
class Solution:
    # @param A, a list of integers
    # @return an integer
    def jump(self, A):
        maxCanReach = 0
        times = 0
        temp = 0
        i = 0
        while i < len(A):
            if maxCanReach >= len(A) - 1:
                break
            while i <= temp:
                maxCanReach = max(maxCanReach, i + A[i])
                i += 1
            times += 1
            temp = maxCanReach

        return times

if __name__ == "__main__":
    solution = Solution()

    print solution.jump([1, 2])
    print solution.jump([1, 1, 1, 1])
    print solution.jump([2, 3, 1, 1, 4])
    print solution.jump([1, 2, 1, 1, 1])
