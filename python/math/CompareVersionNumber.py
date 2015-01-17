class Solution:
    # @param version1, a string
    # @param version2, a string
    # @return an integer
    def compareVersion(self, version1, version2):
        l1 = version1.split(".")
        l2 = version2.split(".")
        
        length = min(len(l1), len(l2))
        
        for i in xrange(length):
            if int(l1[i]) > int(l2[i]):
                return 1
            if int(l1[i]) < int(l2[i]):
                return -1
                
        if len(l1) == len(l2) and len(l1) == length:
            return 0
        
        if len(l1) > length:
            for i in xrange(length, len(l1)):
                if int(l1[i]) != 0:
                    return 1
            return 0
        else:
            for i in xrange(length, len(l2)):
                if int(l2[i]) != 0:
                    return -1
            return 0

if __name__ == "__main__":
    solution = Solution()
    print solution.compareVersion("01", "1")
    print solution.compareVersion("1.0", "1")
