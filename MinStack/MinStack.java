import java.util.*;

class MinStack {
	private Stack<Integer> stack = new Stack<Integer>();
	private Stack<Integer> minStack = new Stack<Integer>();
    public void push(int x) {
        stack.push(x);
        if (!minStack.isEmpty()) {
            int min = minStack.peek();
            if (x < min) {
                minStack.push(x);
            } else {
                minStack.push(min);
            }
        } else {
            minStack.push(x);
        }

    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return  minStack.peek();
    }


    public static void main(String[] args) {
        MinStack ms = new MinStack();
        ms.push(3);
        System.out.println(ms.getMin());
        ms.push(2);
        ms.push(1);
        System.out.println(ms.getMin());
        ms.push(4);
        System.out.println(ms.getMin());
    }
}

