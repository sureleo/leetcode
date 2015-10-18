class Solution:
    # @param matrix, a list of lists of integers
    # RETURN NOTHING, MODIFY matrix IN PLACE.
    def setZeroes(self, matrix):
        firstRowZero = False
        firstColZero = False
        rows = len(matrix)
        cols = len(matrix[0])
        
        for i in xrange(rows):
            if matrix[i][0] == 0:
                firstColZero = True
                break
        
        for i in xrange(cols):
            if matrix[0][i] == 0:
                firstRowZero = True
                break
            
        for i in xrange(1, rows):
            for j in xrange(1, cols):
                if matrix[i][j] == 0:
                    matrix[i][0] = 0
                    matrix[0][j] = 0
        
        for i in xrange(1, rows):
            if matrix[i][0] == 0:
                for j in xrange(1, cols):
                    matrix[i][j] = 0
                    
        for i in xrange(1, cols):
            if matrix[0][i] == 0:
                for j in xrange(1, rows):
                    matrix[j][i] = 0
        
        if firstRowZero:
            for i in xrange(cols):
                matrix[0][i] = 0
        
        if firstColZero:
            for i in xrange(rows):
                matrix[i][0] = 0
