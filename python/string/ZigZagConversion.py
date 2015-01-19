class Solution:
    # @return a string
    def convert(self, s, nRows):
        result = ""
        if nRows == 1:
            return s
        
        group = 2 * nRows - 2
        col_per_group = nRows - 2 + 1
        num_group = len(s) / group
        total_col = num_group * col_per_group
        extra = len(s) % group
        if extra > nRows:
            total_col += (extra - nRows)
        if extra > 0:
            total_col += 1
            
        matrix = [["" for i in xrange(total_col)] for i in xrange(nRows)]
        
        m = -1
        goDown = True
        n = 0
        for i in xrange(len(s)):
            if m == (nRows - 1) and goDown:
                goDown = False
            if goDown:
                m += 1
            else:
                m -= 1
                n += 1
                if m == 0:
                    goDown = True
            matrix[m][n] = s[i]
        
        for i in xrange(nRows):
            for j in xrange(total_col):
                result += matrix[i][j]
                
        return result

if __name__ == "__main__":
    solution = Solution()

    print solution.convert("PAYPALISHIRING", 3)
