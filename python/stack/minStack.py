class MinStack:
    def __init__(self):
        self.stack = []
        self.temp_stack = []
        
    # @param x, an integer
    # @return an integer
    def push(self, x):
        self.stack.append(x)
        if len(self.temp_stack) == 0 or x <= self.temp_stack[-1]:
            self.temp_stack.append(x)
        return x
        
    # @return nothing
    def pop(self):
        if len(self.temp_stack) > 0 and self.temp_stack[-1] == self.stack[-1]:
            self.temp_stack.pop()
        self.stack.pop()
    
    # @return an integer
    def top(self):
        return self.stack[-1]

    # @return an integer
    def getMin(self):
        return self.temp_stack[-1]

if __name__ == "__main__":
    minStack = MinStack()
    
    minStack.push(2)
    minStack.push(0)
    minStack.push(3)
    minStack.push(0)
    print minStack.stack
    print minStack.temp_stack

