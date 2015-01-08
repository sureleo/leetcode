class Solution:
    # @param digits, a list of integer digits
    # @return a list of integer digits
    def plusOne(self, digits):
        carry = 0
        for i in xrange(len(digits)-1, -1, -1):
            if i == len(digits) - 1:
                new_digit = (digits[i] + 1 + carry) % 10
                carry = (digits[i] + 1 + carry) / 10
            else:
                new_digit = (digits[i] + carry) % 10
                carry = (digits[i] + carry) / 10

            digits[i] = new_digit
        
        if carry == 1:
            digits = [1] + digits
        
        return digits


if __name__ == "__main__":
    solution = Solution()
    print solution.plusOne([1, 0])
