class Solution:
    # @param strs, a list of strings
    # @return a list of strings
    def anagrams(self, strs):
        d = { }
        for i in xrange(len(strs)):
            l = list(strs[i])
            l.sort()
            string = "".join(l)
            if string not in d:
                d[string] = [strs[i]]
            else:
                d[string].append(strs[i])

        result = []
        for key in d:
            if len(d[key]) > 1:
                for j in xrange(len(d[key])):
                    result.append(d[key][j])
        return result


if __name__ == "__main__":
    solution = Solution()

    print solution.anagrams(["", "b"])
