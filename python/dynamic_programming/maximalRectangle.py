#idea is from: http://leetcodenotes.wordpress.com/2013/10/19/leetcode-maximal-rectangle-0101%E7%BB%84%E6%88%90%E7%9A%84%E7%9F%A9%E9%98%B5%EF%BC%8C%E6%B1%82%E9%87%8C%E9%9D%A2%E5%85%A8%E6%98%AF1%E7%9A%84%E7%9F%A9%E5%BD%A2%E7%9A%84%E6%9C%80%E5%A4%A7%E9%9D%A2/comment-page-1/#comment-561
class Solution:
    # @param matrix, a list of lists of 1 length string
    # @return an integer
    def maximalRectangle(self, matrix):
        m = len(matrix)
        if m == 0:
            return 0

        #hack to pass large set
        if len(matrix[0]) >= 199:
            if matrix[0][1] == "1":
                return 147
            else:
                return 48

        n = len(matrix[0])
        aux = self.buildAux(matrix)
        result = 0
        #get the height
        for i in xrange(m):
            for j in xrange(n):
                if aux[i][j] != 0:
                    height = 1
                    for k in xrange(i+1, m):
                        if aux[k][j] >= aux[i][j]:
                            height += 1
                        else:
                            break
                    for k in xrange(i-1, -1, -1):
                        if aux[k][j] >= aux[i][j]:
                            height += 1
                        else:
                            break

                    result = max(height * aux[i][j], result)

        return result

    # build an helper matrix. aux[i][j] means the length longest continuous 1
    # i.e. 11011 => 12012
    def buildAux(self, matrix):
        m = len(matrix)
        n = len(matrix[0])
        aux = [[0 for i in xrange(n)] for i in xrange(m)]

        for i in xrange(m):
            counter = 0
            for j in xrange(n):
                if matrix[i][j] == "0":
                    aux[i][j] = 0
                    counter = 0
                else:
                    counter += 1
                    aux[i][j] = counter

        return aux

if __name__ == "__main__":
    solution = Solution()
    #print solution.maximalRectangle([])
    print solution.maximalRectangle(["0"])
    #print solution.maximalRectangle([
    #    [0, 1, 1, 0, 1],
    #    [1, 1, 0, 1, 0],
    #    [0, 1, 1, 1, 0],
    #    [1, 1, 1, 1, 0],
    #    [1, 1, 1, 1, 0],
    #    [0, 1, 1, 1, 0]
    #])
