class MyQueue {
    public int size = 0;
    public Stack<Integer> stack = new Stack<Integer>();
    
    // Push element x to the back of queue.
    public void push(int x) {
        this.size += 1;
        this.stack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        this.size -= 1;
    }

    // Get the front element.
    public int peek() {
        Stack<Integer> temp = new Stack<Integer>();
        for (int i = 0; i < size; i++) {
            temp.push(this.stack.pop());
        }
        
        int result = temp.peek();
        while (temp.isEmpty() == false) {
            this.stack.push(temp.pop());
        }
        
        return result;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return this.size == 0;
    }
}
