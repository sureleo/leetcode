class Solution:
    # @param s, a string
    # @return a string
    def reverseWords(self, s):
        s = s.strip()
        l = s.split(" ")
        result_list = []
        for i in xrange(len(l)):
            if l[i] != '':
                result_list.append(l[i])
        result_list.reverse()
        return " ".join(result_list)

if __name__ == "__main__":
    solution = Solution()

    #print solution.reverseWords("the sky is blue")
    print solution.reverseWords("   a    b")
