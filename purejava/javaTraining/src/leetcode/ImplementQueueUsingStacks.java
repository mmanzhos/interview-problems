package leetcode;

import java.util.Stack;


public class ImplementQueueUsingStacks {

	Stack<Integer> input;
    Stack<Integer> output;
    
    public ImplementQueueUsingStacks() {
        input = new Stack<Integer>();
        output = new Stack<Integer>();
    }
    
    // Push element x to the back of queue.
    public void push(int x) {
        input.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        peek();
        output.pop();
    }

    // Get the front element.
    public int peek() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        return output.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }

}
