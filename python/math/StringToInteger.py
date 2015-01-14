class Solution:
    # @return an integer
    def atoi(self, str):
        i = 0
        INT_MAX = 2147483647
        INT_MIN = -2147483648
        negative = 1
        result = 0
        while i < len(str) and str[i] == " ":
            i += 1
        
        if i == len(str):
            return 0
        
        if str[i] == "-":
            i += 1
            negative = -1
        elif str[i] == "+":
            i += 1
            
        while i < len(str) and str[i].isdigit():
            if negative == 1:
                if INT_MAX / 10 < result or (INT_MAX / 10 == result and int(str[i]) >= 7):
                    return INT_MAX
            else:
                if (0-INT_MIN) / 10 < result or ((0-INT_MIN) / 10 == result and int(str[i]) >= 8):
                    return INT_MIN
            result = result * 10 + int(str[i])
            i += 1
                
        if i < len(str) and not str[i].isdigit:
            while i < len(str):
                if str[i].isdigit():
                    return 0
                i += 1
        
        return negative * result

if __name__ == "__main__":
    solution = Solution()

    #print solution.atoi("1")
    #print solution.atoi("-+1")
    #print solution.atoi("2147483647")
    #print solution.atoi("2147483648")
    #print solution.atoi("2147483648")
    print solution.atoi("-2147483649")
