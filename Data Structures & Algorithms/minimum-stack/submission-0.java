class MinStack {
    Deque<Integer> mainS, helperS;

    public MinStack() {
        mainS = new ArrayDeque<Integer>();
        helperS = new ArrayDeque<Integer>();
    }
    
    public void push(int val) {
        mainS.push(val);
        int currMin;
        if (helperS.isEmpty()) currMin = Integer.MAX_VALUE;
        else currMin = helperS.peek();
        helperS.push(val);
        if (currMin>val) helperS.push(val);
        else helperS.push(currMin);
    }
    
    public void pop() {
        mainS.pop();
        helperS.pop();
        helperS.pop();
    }
    
    public int top() {
        return mainS.peek();
    }
    
    public int getMin() {
        return helperS.peek();
    }
}
