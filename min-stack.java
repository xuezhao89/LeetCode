/*
题目：
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
Example:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.

思路：
创建一个主栈Stack，另创建一个副栈minStack专门把最小值存放在栈顶。

注意：
1.判断是否加入minStack时，等于stack.pop()的情况也要放入，因为可能有多个重复的最小值，我们需要多次抛出这些重复的最小值; 
2.判断minStack是否需要pop时，切记判断：minStack是否为空和minStack.peek()是否等于stack.pop()，一样大才可以pop。                                    
*/

class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else {
            if (x <= minStack.peek()) {
                minStack.push(x);
            }
        }
    }
    
    public void pop() {
        int val = stack.pop();
        if (!minStack.isEmpty() && minStack.peek() == val) {
            minStack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        if (!minStack.isEmpty()) {
            return minStack.peek();
        } else {
            return 0;
        }
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */