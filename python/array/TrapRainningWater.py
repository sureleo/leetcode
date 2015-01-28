class Solution:
    # @param A, a list of integers
    # @return an integer
    def trap(self, A):
        if len(A) == 0:
            return 0

        start = 0
        stack = []
        result = 0
        #trim 0 at the beginning
        while start < len(A) and A[start] == 0:
            start += 1
        stack.append(start)

        i = start + 1
        while i < len(A):
            #be careful: if stack is empty, we should push no matter what
            #if A[i] is not greater than top of the stack, we push
            #otherwise, it turns out we can trap some water, then pop
            #compute with formula: length * height
            #which length is min(topOfTheStack, A[i]) - height of poped element
            #and length is i - topOfTheStack - 1
            #let me try to draw a diagram:
            """
            #    #
            #    #
            #    #
            ## # #
            ######
            012345
            push index 0, push index 1, push index 2
            then A[3] is greater than A[2], we pop A[2] and compute area noted by *
            #    #
            #    #
            #    #
            ##*# #
            ######
            push index 3, push index 4
            A[5] is greater than A[4], we pop A[4] and compute area noted by *
            #    #
            #    #
            #    #
            ##*#*#
            ######
            what now? A[5] is still greater than the top of our stack! which is A[3]
            we compute area noted by o
            #  oo#
            #  oo#
            #  oo#
            ##*#*#
            ######
            continue, still A[1] less than A[5]
            #oooo#
            #oooo#
            #oooo#
            ##*#*#
            ######
            so, area of o + * is 14
            """
            if len(stack) == 0 or A[i] <= A[stack[-1]]:
                stack.append(i)
                i += 1
            else:
                top = stack[-1]
                stack.pop()
                #be careful: if stack is empty, we should continue no matter what
                if len(stack) > 0:
                    height = min(A[stack[-1]], A[i]) - A[top]
                    length = i - stack[-1] - 1
                    result += height * length

        return result

if __name__ == "__main__":
    solution = Solution()

    print solution.trap([5, 0, 1, 0, 2])
    print solution.trap([0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1])
