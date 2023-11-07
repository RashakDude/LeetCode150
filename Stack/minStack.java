class MinStack {

    private class Node{
        int min;
        int val;
        Node next;
        Node prev;
        Node(int min,int val) {
            this.min = min;
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    private Node point = null;

    public MinStack() {
        
    }
    
    public void push(int val) {
        int min = Math.min(val, point == null ? Integer.MAX_VALUE : point.min);
        Node temp = new Node(min, val);
        if (point == null) point = temp;
        else {
            point.next = temp;
            temp.prev = point;
            point = point.next;
        }
    }
    
    public void pop() {
        Node temp = point.prev;
        if (temp != null) temp.next = null;
        point.prev = null;
        point = temp;
    }
    
    public int top() {
        return point.val;
    }
    
    public int getMin() {
        return point.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */