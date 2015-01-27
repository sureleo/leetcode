#mistakes were made:
#0. should use dict to store index rather than value
#in this case, we won't use a same number twice
class Solution:
    # @return a list of lists of length 4, [[val1,val2,val3,val4]]
    def fourSum(self, num, target):
        d = {}
        num.sort()
        result = set()
        result_list = []
        for i in xrange(len(num)):
            for j in xrange(i+1, len(num)):
                curr = num[i] + num[j]
                if curr not in d:
                    d[curr] = [(i, j)]
                else:
                    d[curr].append((i, j))

        for i in xrange(len(num)):
            for j in xrange(i+1, len(num)):
                temp = target - num[i] - num[j]
                if temp in d:
                    for k in xrange(len(d[temp])):
                        if d[temp][k][0] > j:
                            result.add((num[i], num[j], num[d[temp][k][0]], num[d[temp][k][1]]))
        for i in result:
            result_list.append(list(i))

        return result_list

if __name__ == "__main__":
    solution = Solution()

    print solution.fourSum([-2, -1, 0, 0, 1, 2], 0)
