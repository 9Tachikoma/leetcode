class MyStack {
    private Queue<Integer> q;
    int top_elem = 0;

    public MyStack() {
        q = new LinkedList<>();
    }

    public void push(int x) {
        q.offer(x);
        top_elem = x;
    }

    public int pop() {
        int size = q.size();
        //留下队尾的两个元素
        while(size>2){
            q.offer(q.poll());
            size--;
        }
        //第一个元素为栈顶，应当维护
        top_elem = q.peek();
        q.offer(q.poll());
        return q.poll();
    }

    public int top() {
        return top_elem;
    }

    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */