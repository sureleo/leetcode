class Solution:
    # @return a string
    def countAndSay(self, n):
        result = "1"
        if n == 1:
            return result
        
        for i in xrange(2, n+1):
            new_result = ""
            curr_count = 1
            curr_num = result[0]
            for j in xrange(1, len(result)):
                if result[j-1] == result[j]:
                    curr_count += 1
                else:
                    new_result += str(curr_count)
                    new_result += str(curr_num)
                    curr_count = 1
                    curr_num = result[j]

            new_result += str(curr_count)
            new_result += str(curr_num)
            result = new_result
        return result

if __name__ == "__main__":
    solution = Solution()

    print solution.countAndSay(3)
