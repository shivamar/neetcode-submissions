class MinStack {

    Stack<MinTracker> stack;


    public MinStack() {
       stack = new Stack<MinTracker>();
    }
    
    public void push(int val) {
        MinTracker minTracker = new MinTracker();
        minTracker.val = val;
    //if empty add value as minSeen, if stack.is not empty,minSeenSofar is smaller of val , stack.peek().val
       if(stack.isEmpty()) minTracker.minSeenSoFar = val;
       else {
        int minPrev = stack.peek().minSeenSoFar;
        minTracker.minSeenSoFar = Math.min(val,minPrev);
       }

        stack.push(minTracker);
    }
    
    public void pop() {
         MinTracker minTracker = stack.pop();
    }
    
    public int top() {
        return stack.peek().val;
    }
    
    public int getMin() {
        return stack.peek().minSeenSoFar;
    }

    class MinTracker {
    public int val;
    public int minSeenSoFar;
}
}


