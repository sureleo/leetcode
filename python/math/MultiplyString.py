class Solution:
    # @param num1, a string
    # @param num2, a string
    # @return a string
    def multiply(self, num1, num2):
        len_arr = len(num1) + len(num2) - 1
        arr = [0 for i in xrange(len_arr)]
        for i in xrange(len(num1)-1, -1, -1):
            for j in xrange(len(num2)-1, -1, -1):
                arr[i+j] += int(num1[i]) * int(num2[j])

        carry = 0
        for i in xrange(len_arr-1, -1, -1):
            temp = (arr[i] + carry) % 10
            carry = (arr[i] + carry) / 10
            arr[i] = temp
            
        if carry != 0:
            arr = [carry] + arr

        result = ""
        trailingZero = True
        for i in xrange(len(arr)):
            if arr[i] != 0:
                trailingZero = False
            if arr[i] == 0 and i != len(arr)-1 and trailingZero:
                continue
            result += str(arr[i])
            
        return result

if __name__ == "__main__":
    solution = Solution()
    print solution.multiply("0", "0")
    print solution.multiply("123", "27")
    print solution.multiply("9", "9")
    print solution.multiply("9133", "0")
    print solution.multiply("123", "456")
