#Thought about swap element in the array but it was a chaos
#Get it from here:http://fisherlei.blogspot.com/2012/12/leetcode-next-permutation.html
#actually these code allocated extra memory for copying list
#will try to optimize this in C++
class Solution:
    # @param num, a list of integer
    # @return a list of integer
    def nextPermutation(self, num):
        vioIndex = 0
        for i in xrange(len(num)-2, -1, -1):
            if num[i] < num[i+1]:
                vioIndex = i
                break
            else:
                if i == 0:
                    num.reverse()
                    return num

        for i in xrange(len(num)-1, -1, -1):
            if num[i] > num[vioIndex]:
                temp = num[i]
                num[i] = num[vioIndex]
                num[vioIndex] = temp
                break
                
        b = num[vioIndex+1:]
        b.reverse()
        num[vioIndex+1:] = b
        
        return num

if __name__ == "__main__":
    solution = Solution()

    print solution.nextPermutation([3, 2, 1])
