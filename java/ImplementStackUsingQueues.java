class MyStack {
    public int size = 0;
    public Queue<Integer> queue = new LinkedList<Integer>();
    
    // Push element x onto stack.
    public void push(int x) {
        queue.add(x);
        size += 1;
    }

    // Removes the element on top of the stack.
    public void pop() {
        Queue<Integer> temp = new LinkedList<Integer>();
        int i = 0;
        while (i < size - 1) {
            int t = queue.poll();
            temp.add(t);
            i += 1;
        }
        
        size --;
        this.queue = new LinkedList<Integer>(temp);
    }

    // Get the top element.
    public int top() {
        int i = 0;
        int result = 0;
        while (i < size) {
            int temp = queue.poll();
            queue.add(temp);
            i += 1;
            if (i == size) {
                result = temp;
            }
        }
        
        return result;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return size == 0;
    }
}
