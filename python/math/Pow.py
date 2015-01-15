class SolutionWithDictionary:
    # @param x, a float
    # @param n, a integer
    # @return a float
    def __init__(self):
        self.d = {}

    def pow(self, x, n):
        if n < 0:
            return 1 / self.pow(x, 0-n)
        elif n == 1:
            return x
        elif n == 0:
            return 1
        elif n % 2 == 0:
            if n not in self.d:
                self.d[n] = self.pow(x, n/2) 
            return self.d[n] * self.d[n] 
        else:
            if n not in self.d:
                self.d[n] = self.pow(x, n/2) 
            return self.d[n] * self.d[n] * x

class Solution:
    # @param x, a float
    # @param n, a integer
    # @return a float
    def pow(self, x, n):
        if n < 0:
            return 1 / self.pow(x, 0-n)
        elif n == 1:
            return x
        elif n == 0:
            return 1
        elif n % 2 == 0:
            return self.pow(x*x, n/2)
        else:
            return self.pow(x*x, n/2) * x

if __name__ == "__main__":
    solution = Solution()
    print solution.pow(8.88023, 3)
