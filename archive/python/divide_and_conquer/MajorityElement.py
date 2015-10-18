class Solution:
    # @param num, a list of integers
    # @return an integer
    def majorityElement(self, num):
        if len(num) == 0:
            return None
        if len(num) == 1:
            return num[0]
        if len(num) == 2:
            if num[0] == num[1]:
                return num[0]
            else:
                return None
    
        first_half = self.majorityElement(num[:len(num)/2])
        second_half = self.majorityElement(num[len(num)/2:])

        if first_half is None:
            return second_half
        if second_half is None:
            return first_half
            
        if first_half == second_half:
            return first_half
        else:
            first_counter = 0
            second_counter = 0
            for i in xrange(len(num)):
                if num[i] == first_half:
                    first_counter += 1
                if num[i] == second_half:
                    second_counter += 1
                
            if first_counter > second_counter:
                return first_half
            else:
                return second_half

if __name__ == "__main__":
    solution = Solution()

    #print solution.majorityElement([6, 6, 6, 7, 7])
    #print solution.majorityElement([6, 5, 5])
    print solution.majorityElement([-2147483648, 0, 0])
