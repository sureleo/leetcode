#http://www.cnblogs.com/reachteam/p/4222486.html
#I couldn't get the second solution without this hint.
#used a long time to implement insertion sort. need to solid my fundemental
class Solution:
    def largestNumber(self, num):
        for i in xrange(len(num)):
            for j in xrange(i):
                a = str(num[i])
                b = str(num[j])
                if int(a+b) > int(b+a):
                    temp = num[i]
                    del num[i]
                    num.insert(j, temp)

        result = ""
        for i in xrange(len(num)):
            result += str(num[i])

        for i in xrange(len(result)):
            if result[i] != '0':
                return result

        return '0'

if __name__ == "__main__":
    solution = Solution()

    print solution.largestNumber([3, 30, 34, 5, 9])
    print solution.largestNumber([0, 0])
    print solution.largestNumber([3577, 9155, 9352, 7911, 1622])
    print solution.largestNumber([8834, 8074, 7956, 4343, 8658, 1851])
