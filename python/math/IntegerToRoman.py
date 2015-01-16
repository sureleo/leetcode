class Solution:
    # @return a string
    def __init__(self):
        self.result = ""
        self.d = {}
        self.num = 0
        
    def fit(self, threshold):
        while self.num >= threshold:
            self.result += self.d[threshold]
            self.num = self.num - threshold
            
    def intToRoman(self, num):
        self.d = {
            1: "I", 5: "V", 10: "X", 50: "L",
            100: "C", 500: "D", 1000: "M",
            4: "IV", 9: "IX", 40: "XL", 90: "XC",
            400: "CD", 900: "CM"
        }
        
        self.num = num
        
        self.fit(1000)
        l = [900, 500, 400, 100]
        for j in xrange(3):
            for i in xrange(len(l)):
                self.fit(l[i])
                l[i] = l[i]/10

        return self.result

if __name__ == "__main__":
    solution = Solution()
    print solution.intToRoman(3999)
    print solution.intToRoman(5)
