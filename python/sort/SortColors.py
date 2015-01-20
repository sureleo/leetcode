#at first I tried with simply a for loop.
#however, when I delete an element in the array, the index has messed up
class Solution:
    # @param A a list of integers
    # @return nothing, sort in place
    def sortColors(self, A):
        j = 0
        i = 0
        while j < len(A):
            if A[i] == 1:
                i += 1
                j += 1
                continue
            elif A[i] == 0:
                del A[i]
                A.insert(0, 0)
                i += 1
            else:
                del A[i]
                A.append(2)
            j += 1

if __name__ == "__main__":
    solution = Solution()

    solution.sortColors([1, 2, 0])
