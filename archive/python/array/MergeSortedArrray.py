class Solution:
    # @param A  a list of integers
    # @param m  an integer, length of A
    # @param B  a list of integers
    # @param n  an integer, length of B
    # @return nothing
    def merge(self, A, m, B, n):
        l = m + n - 1
        while m - 1 >= 0 and n - 1 >= 0:
            if A[m-1] > B[n-1]:
                A[l] = A[m-1]
                m -= 1
            else:
                A[l] = B[n-1]
                n -= 1
            l -= 1
        
        while m - 1 >= 0:
            A[l] = A[m-1]
            l -= 1
            m -= 1
        
        while n - 1 >= 0:
            A[l] = B[n-1]
            l -= 1
            n -= 1
    
