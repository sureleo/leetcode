class Solution:
    # @return a string
    def fractionToDecimal(self, numerator, denominator):
        negative = False 
        if numerator < 0 and denominator > 0:
            numerator = 0 - numerator
            negative = True

        if numerator > 0 and denominator < 0:
            denominator = 0 - denominator
            negative = True

        if numerator < 0 and denominator < 0:
            numerator = 0 - numerator
            denominator = 0 - denominator

        pre_decimal = numerator/denominator
        result = str(pre_decimal)
        if numerator%denominator != 0:
            result += "."
            hash = {}
            queue = []
            new_n = numerator % denominator
            while new_n not in hash and new_n != 0:
                temp = new_n * 10 / denominator
                hash[new_n] = temp
                queue.append(new_n)
                new_n = new_n * 10 % denominator
            
            if new_n == 0:
                for i in xrange(len(queue)):
                    result += str(hash[queue[i]])
            else:
                for i in xrange(len(queue)):
                    if queue[i] == new_n:
                        result += "("
                    result += str(hash[queue[i]])
                result += ")"

        if negative:
            return "-" + result

        return result

if __name__ == "__main__":
    solution = Solution()
    print solution.fractionToDecimal(1, 2)
    print solution.fractionToDecimal(2, 1)
    print solution.fractionToDecimal(2, 3)
    print solution.fractionToDecimal(1, 17)
    print solution.fractionToDecimal(-50, 8)
