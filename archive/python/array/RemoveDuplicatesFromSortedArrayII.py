#Too many mistakes were made.
#0. should use while loop instead of for.
#1. messed up with index. maybe with the sleepy head at 3pm
class Solution:
    # @param a list of integers
    # @return an integer
    def removeDuplicates(self, A):
        result = len(A)
        if result == 0:
            return result

        curr = 0
        next_index = 1
        start_index = 1
        if next_index < len(A) and A[next_index] == A[curr]:
            next_index += 1
            start_index += 1

        i = start_index
        while i < len(A):
            if A[i] > A[curr]:
                temp = A[next_index]
                A[next_index] = A[i]
                A[i] = temp
                curr = next_index
                next_index += 1
                if (i + 1) < len(A) and A[i+1] == A[curr]:
                    A[next_index] = A[i+1]
                    next_index += 1
                    i += 1
            else:
                result -= 1
            i += 1
            print A

        return result

if __name__ == "__main__":
    solution = Solution()
    A = [1, 1, 1, 1, 2, 2, 2, 2, 3]
    result = solution.removeDuplicates(A)
    print A[:result]
