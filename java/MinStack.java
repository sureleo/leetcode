class MinStack {
    public Stack<Integer> s = new Stack<Integer>();
    public Stack<Integer> helper = new Stack<Integer>();
    
    public void push(int x) {
        if (helper.isEmpty() == true || x <= helper.peek()) {
            helper.push(x);
        }
        s.push(x);
    }

    public void pop() {
        int top = s.pop();
        if (helper.isEmpty() == false && top == helper.peek()) {
            helper.pop();
        }
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return helper.peek();
    }
}

