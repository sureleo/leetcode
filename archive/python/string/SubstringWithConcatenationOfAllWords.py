#Got TLE at first: I didn't create a new dic. However, I did a copy of "d" everytime,
#Seems this cost is really considerable
class Solution:
    # @param S, a string
    # @param L, a list of string
    # @return a list of integer
    def findSubstring(self, S, L):
        d = {}
        count = len(L)
        result = []
        for i in xrange(len(L)):
            if L[i] not in d:
                d[L[i]] = 1
            else:
                d[L[i]] += 1

        for i in xrange(len(S) - len(L) * len(L[0]) + 1):
            curr_d = {}
            temp = i
            while S[temp:temp+len(L[0])] in d:
                curr = S[temp:temp+len(L[0])]
                if curr not in curr_d:
                    curr_d[curr] = 1
                else:
                    curr_d[curr] += 1

                if curr_d[curr] > d[curr]:
                    break
                else:
                    count -= 1
                if count == 0:
                    result.append(i)
                    break
                temp += len(L[0])
            count = len(L)

        return result

if __name__ == "__main__":
    solution = Solution()

    print solution.findSubstring("abababab", ["a", "b", "a"])
