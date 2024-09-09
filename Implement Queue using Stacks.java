//Day 45 of #CrackYourInternship
class MyQueue {
    Stack<Integer> stack;
    Stack<Integer> s;
    public MyQueue() {
        stack = new Stack<>();
        s = new Stack<>();
    }
    
    public void push(int x) {
        while(!stack.isEmpty()){
            s.push(stack.pop());
        }
        stack.push(x);
        while(!s.isEmpty()){
            stack.push(s.pop());
        }
    }
    
    public int pop() {
        return stack.pop();
    }
    
    public int peek() {
        return stack.peek();
    }
    
    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
