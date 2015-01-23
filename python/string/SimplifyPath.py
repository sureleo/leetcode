class Solution:
    # @param path, a string
    # @return a string
    def simplifyPath(self, path):
        l = path.split("/")
        stack = []
        result = "/"
        
        for i in xrange(len(l)):
            if l[i] == "" or l[i] == ".":
                continue
            elif l[i] == "..":
                if len(stack) == 0:
                    continue
                else:
                    stack.pop()
            else:
                stack.append(l[i])
        
        for i in xrange(len(stack)):
            result += stack[i]
            if i != len(stack) - 1:
                result += "/"
        
        return result
