#Overconfidence makes you careless
class Solution:
    # @return a string
    def convertToTitle(self, num):
        d = {
            1:'A', 2:'B', 3:'C', 4:'D', 5:'E',
            6:'F', 7:'G', 8:'H', 9:'I', 10:'J',
            11:'K', 12:'L', 13:'M', 14:'N', 15:'O',
            16:'P', 17:'Q', 18:'R', 19:'S', 20:'T',
            21:'U', 22:'V', 23:'W', 24:'X', 25:'Y', 0:'Z'
        }

        result = ""
        while num > 0:
            temp = num % 26
            result += d[num%26]
            if temp == 0:
                temp = 26
            num = (num - temp) / 26

        return result[::-1]
            
if __name__ == "__main__":
    solution = Solution()
    print solution.convertToTitle(26)
