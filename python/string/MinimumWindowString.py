#Solution from: http://www.cnblogs.com/zuoyuan/p/3785421.html
#use "count" to check whether there's a match
#one dictionary should be enough for this problem
class Solution:
    # @return a string
    def minWindow(self, S, T):
        maxlength = 10 ** 10
        result = ""
        start = 0
        count = len(T)
        dictT = {}
        for i in xrange(len(T)):
            if T[i] not in dictT:
                dictT[T[i]] = 1
            else:
                dictT[T[i]] += 1

        for i in xrange(len(S)):
            if S[i] in dictT:
                dictT[S[i]] -= 1
                if dictT[S[i]] >= 0:
                    count -= 1
            if count == 0:
                while True:
                    if S[start] in dictT:
                        if dictT[S[start]] >= 0:
                            break
                        dictT[S[start]] += 1
                    start += 1
                
                if (i - start + 1) < maxlength:
                    maxlength = i - start + 1
                    result = S[start:i+1]

        return result

if __name__ == "__main__":
    solution = Solution()

    print solution.minWindow("ADOBECODEBANC", "ABC")
