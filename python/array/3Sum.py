#mistakes were made:
#0. I hold "left-[0]" and "right[-1]" which is a bad idea. after adding left and right,
#you can't know we should shrink left or right.
#1. Alright, we don't know where to shrink, so I tried with a recursive way. Well,
#obviously, this takes O(2^n)
#http://www.cnblogs.com/zuoyuan/p/3699159.html <-- this one's good
class Solution:
    # @return a list of lists of length 3, [[val1,val2,val3]]
    def threeSum(self, num):
        result = []
        if len(num) == 0:
            return result
        num.sort()

        for i in xrange(len(num)-2):
            if i == 0 or num[i] > num[i-1]:
                left = i + 1
                right = len(num) - 1
                while left < right:
                    curr = num[i] + num[left] + num[right]
                    if curr == 0:
                        result.append([num[i], num[left], num[right]])
                        newLeft = left 
                        while newLeft < right and num[newLeft] == num[left]:
                            newLeft += 1
                        left = newLeft
                        newRight = right
                        while left < newRight and num[newRight] == num[right]:
                            newRight -= 1
                        right = newRight
                    elif curr < 0:
                        newLeft = left 
                        while newLeft < right and num[newLeft] == num[left]:
                            newLeft += 1
                        left = newLeft
                    else:
                        newRight = right
                        while left < newRight and num[newRight] == num[right]:
                            newRight -= 1
                        right = newRight
                
        return result

if __name__ == "__main__":
    solution = Solution()

    print solution.threeSum([-2, 0, 1, 1, 2])
    #print solution.threeSum([-10, -10, -9, -8, -7, -7, -7, -6, -5, -4, -3, -3, -1, 0, 2, 5, 5, 7, 8, 9])
    print solution.threeSum([0, 0, 0, 0])
