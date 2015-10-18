class Solution:
    # @return a float
    def findMedianSortedArrays(self, A, B):
        total = len(A) + len(B)
        if total % 2 == 0:
            first_half = self.getKth(total/2, A, B)
            second_half = self.getKth(total/2+1, A, B)
            return (float(first_half) + float(second_half)) / 2
        else:
            return self.getKth(total/2+1, A, B)

    #This solution is from 
    #http://www.cnblogs.com/zuoyuan/p/3759682.html
    #It makes this problem really easy. Actually I have thought about it.
    #I didn't use it at the beginning just because I don't think this approach is Binary Search
    def getKth(self, k, A, B):
        if len(A) > len(B):
            return self.getKth(k, B, A)
        if len(B) == 0:
            return A[k-1]
        if k == 1:
            return min(A[0], B[0])

        pa = min(k/2, len(A))
        pb = k - pa
        if A[pa-1] <= B[pb-1]:
            return self.getKth(k-pa, A[pa:], B)
        else:
            return self.getKth(k-pb, A, B[pb:])
        
    #This solution is kinda like
    #http://fisherlei.blogspot.com/2012/12/leetcode-median-of-two-sorted-arrays.html
    #I really believe this would work, but I can't fix it. Really messup with the index =(
    #I have spent a whole afternoon and an evening but still can't solve it.
    def getKthNeedToBeFixed(self, k, A, B):
        if len(A) == 0:
            return B[k-1]
        if len(B) == 0:
            return A[k-1]
        if k <= 1:
            return min(A[0], B[0])
        
        midA = len(A) / 2
        midB = len(B) / 2
        if A[midA] <= B[midB]:
            if (midA + midB) >= k:
                return self.getKth(k, A, B[:midB+1])
            else:
                return self.getKth(k-(midA), A[midA:], B)
        else:
            if (midA + midB) > k:
                return self.getKth(k, A[:midA+1], B)
            else:
                return self.getKth(k-(midB), A, B[midB:])
            
if __name__ == "__main__":
    solution = Solution()

    print solution.findMedianSortedArrays([1, 7, 8, 20, 27, 35, 40], [2, 50, 80])
    print solution.findMedianSortedArrays([20, 27, 35, 40], [2, 50])
    #print solution.findMedianSortedArrays([3, 4], [1, 2, 5, 6])
    #print solution.getKth(4, [1, 2, 5, 6], [3, 4])
    #print solution.getKth(3, [1, 2, 5, 6], [4])
