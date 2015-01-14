class Solution:
    # @param a, a string
    # @param b, a string
    # @return a string
    def addBinary(self, a, b):
        length = min(len(a), len(b))
        result = ""
        carry = 0
        for i in xrange(length-1, -1, -1):
            if len(a) > len(b):
                temp = carry + int(a[i+len(a)-len(b)]) + int(b[i])
            else:
                temp = carry + int(a[i]) + int(b[i+len(b)-len(a)])
            carry = temp / 2
            result += str(temp % 2)
            
        if length == len(a):
            for i in xrange(len(b)-length-1, -1, -1):
                temp = carry + int(b[i])
                carry = temp / 2
                result += str(temp % 2)
        else:
            for i in xrange(len(a)-length-1, -1, -1):
                temp = carry + int(a[i])
                carry = temp / 2
                result += str(temp % 2)
        
        if carry == 1:
            result += "1"
            
        return result[::-1]

if __name__ == "__main__":
    solution = Solution()
    print solution.addBinary("100", "110010")
