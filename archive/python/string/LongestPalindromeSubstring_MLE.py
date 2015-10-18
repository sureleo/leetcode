class Solution:
    # @return a string
    def longestPalindrome(self, s):
        opt = [[False for i in xrange(len(s))] for i in xrange(len(s))]
        
        for i in xrange(len(s)):
            opt[i][i] = True


        for i in xrange(len(s)-2, -1, -1):
            for j in xrange(len(s) - i - 1):
                opt[i][i+j+1] = s[i] == s[i+j+1] and opt[i+1][i+j]

        maxLength = 1
        max_start = 0
        max_end = 0
        for i in xrange(len(s)):
            for j in xrange(len(s)):
                start = i
                if opt[i][j] == True:
                    if (j - i + 1) > maxLength:
                        max_start = i
                        max_end = j
                        maxLength = j - i + 1
                        
        return s[max_start:max_end+1]

if __name__ == "__main__":
    solution = Solution()

    print solution.longestPalindrome("jhgtrclvzumufurdemsogfkpzcwgyepdwucnxrsubrxadnenhvjyglxnhowncsubvdtftccomjufwhjupcuuvelblcdnuchuppqpcujernplvmombpdttfjowcujvxknzbwmdedjydxvwykbbamfnsyzcozlixdgoliddoejurusnrcdbqkfdxsoxxzlhgyiprujvvwgqlzredkwahexewlnvqcwfyahjpeiucnhsdhnxtgizgpqphunlgikogmsffexaeftzhblpdxrxgsmeascmqngmwbotycbjmwrngemxpfakrwcdndanouyhnnrygvntrhcuxgvpgjafijlrewfhqrguwhdepwlxvrakyqgstoyruyzohlvvdhvqmzdsnbtlwctetwyrhhktkhhobsojiyuydknvtxmjewvssegrtmshxuvzcbrabntjqulxkjazrsgbpqnrsxqflvbvzywzetrmoydodrrhnhdzlajzvnkrcylkfmsdode")
