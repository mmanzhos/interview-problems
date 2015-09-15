package olimp;

import java.util.ArrayList;

public class StacksSolutions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// StackWithMin stack = new StackWithMin();
		//
		// stack.push(5);
		// stack.push(9);
		// stack.push(15);
		// stack.push(3);
		// stack.push(6);
		// stack.push(1);
		// stack.push(22);
		// stack.push(99);
		// stack.push(31);
		//
		// System.out.println("min = " + stack.min());

		// StackArray stack = new StackArray();
		// StackArray4 stack = new StackArray4();

		SetOfStacks set = new SetOfStacks(100);
		
		for(int i = 0; i < 354; i++){
			set.push(i);
		}
		
		//Stack last = set.getLastStack();
		System.out.println("size = "+set.stacks.size());
		set.pop();
		set.pop();
		set.pop();
		set.pop();
		set.pop();
		set.pop();
		set.pop();
		set.pop();
		set.pop();
		set.pop();set.pop();set.pop();set.pop();set.pop();set.pop();set.pop();
		System.out.println("size = "+set.stacks.size());
		
		/*
		 * stack.push(0, 5); stack.push(0, 9); stack.push(0, 15); stack.push(1,
		 * 3); stack.push(1, 6); stack.push(1, 1); stack.push(0, 22);
		 * stack.push(1, 99); stack.push(0, 31);
		 */

		/*
		 * System.out.println("peek = " + stack.peek(0));
		 * 
		 * System.out.println("isEmpty = " + stack.isEmpty(1));
		 * 
		 * while (!stack.isEmpty(0)) System.out.println(stack.pop(0));
		 */

		/*
		 * System.out.println(stack.pop(0)); System.out.println(stack.pop(0));
		 * System.out.println(stack.pop(0)); System.out.println(stack.pop(1));
		 * System.out.println(stack.pop(2)); System.out.println(stack.pop(2));
		 */

	}

}

class StackArray {
	int stackSize = 300;
	int[] buffer = new int[stackSize * 3];
	int[] stackPointer = { 0, 0, 0 }; // stack pointers to track top elem

	void push(int stackNum, int value) {

		/*
		 * * Find the index of the top element in the array + 1, and increment
		 * the stack pointer
		 */

		int index = stackNum * stackSize + stackPointer[stackNum] + 1;
		stackPointer[stackNum]++;
		buffer[index] = value;
	}

	int pop(int stackNum) {
		int index = stackNum * stackSize + stackPointer[stackNum];
		stackPointer[stackNum]--;
		int value = buffer[index];
		buffer[index] = 0;
		return value;
	}

	int peek(int stackNum) {
		int index = stackNum * stackSize + stackPointer[stackNum];
		return buffer[index];
	}

	boolean isEmpty(int stackNum) {
		return stackPointer[stackNum] == stackNum * stackSize;
	}
}

class StackArray2 {

	int stackSize = 10;
	int[] stacksHolder = new int[stackSize * 3];
	int[] stackPointer = { -1, -1, -1 };

	void push(int stackNum, int value) {
		int index = stackNum * stackSize + stackPointer[stackNum] + 1;
		stackPointer[stackNum]++;
		stacksHolder[index] = value;
	}

	int pop(int stackNum) {
		int index = stackNum * stackSize + stackPointer[stackNum];
		int prevValue = stacksHolder[index];
		stacksHolder[index] = 0;
		stackPointer[stackNum]--;
		return prevValue;
	}

	int peek(int stackNum) {
		return stacksHolder[stackNum * stackSize + stackPointer[stackNum]];
	}

	boolean isEmpty(int stackNum) {
		return stackPointer[stackNum] == -1;
	}

}

/*
 * class StackArray3 { int stackSize = 300; int indexUsed = 0; int[]
 * stackPointer = { -1, -1, -1 }; StackNode[] buffer = new StackNode[stackSize *
 * 3];
 * 
 * void push(int stackNum, int value) { int lastIndex = stackPointer[stackNum];
 * stackPointer[stackNum] = indexUsed; indexUsed++;
 * buffer[stackPointer[stackNum]] = new StackNode(lastIndex, value); }
 * 
 * int pop(int stackNum) { int value = buffer[stackPointer[stackNum]].value; int
 * lastIndex = stackPointer[stackNum]; stackPointer[stackNum] =
 * buffer[stackPointer[stackNum]].previous; buffer[lastIndex] = null;
 * indexUsed--; return value; }
 * 
 * int peek(int stack) { return buffer[stackPointer[stack]].value; }
 * 
 * boolean isEmpty(int stackNum) { return stackPointer[stackNum] == -1; }
 * 
 * class StackNode { public int previous; public int value;
 * 
 * public StackNode(int p, int v) { value = v; previous = p; } } }
 */

class StackArray4 {
	int indexUsed = 0;
	int stackSize = 10;
	StackNode[] stacksHolder = new StackNode[stackSize * 3];
	int[] stackPointer = { -1, -1, -1 };

	void push(int stackNum, int value) {
		int lastIndex = stackPointer[stackNum];
		stackPointer[stackNum] = indexUsed;
		stacksHolder[indexUsed] = new StackNode(lastIndex, value);
		indexUsed++;
	}

	int pop(int stackNum) {
		int prevIndex = stacksHolder[stackPointer[stackNum]].prev;
		int value = stacksHolder[stackPointer[stackNum]].value;
		stacksHolder[stackPointer[stackNum]] = null;
		stackPointer[stackNum] = prevIndex;
		indexUsed--;
		return value;
	}

	int peek(int stackNum) {
		return stacksHolder[stackPointer[stackNum]].value;
	}

	boolean isEmpty(int stackNum) {
		return stackPointer[stackNum] == -1;
	}

	class StackNode {
		public int prev;
		public int value;

		public StackNode(int p, int v) {
			prev = p;
			value = v;
		}
	}
}

// class StackWithMin extends Stack<Integer> {
//
// public int min = Integer.MAX_VALUE;
//
// public void push(int value) {
// min = Math.min(value, min);
// super.push(value);
// }
//
// public int min() {
// if (this.isEmpty()) {
// return Integer.MAX_VALUE;
// } else {
// return min;
// }
// }
// }

class SetOfStacks {
	ArrayList<Stack> stacks = new ArrayList<Stack>();
	public int capacity;

	public SetOfStacks(int capacity) {
		this.capacity = capacity;
	}

	public Stack getLastStack() {
		if (stacks.size() == 0)
			return null;
		return stacks.get(stacks.size() - 1);
	}

	public void push(int v) {
		Stack last = getLastStack();
		if (last != null && !last.isAtCapacity()) { // add to last stack
			last.push(v);
		} else { // must create new stack
			Stack stack = new Stack(capacity);
			stack.push(v);
			stacks.add(stack);
		}
	}

	public int pop() {
		Stack last = getLastStack();
		System.out.println(stacks.size());
		int v = (int) last.pop();
		if (last.size == 0)
			stacks.remove(stacks.size() - 1);
		return v;
	}

	public int popAt(int index) {
		return leftShift(index, true);
	}

	public int leftShift(int index, boolean removeTop) {
		Stack stack = stacks.get(index);
		int removed_item;
		if (removeTop)
			removed_item = stack.pop();
		else
			removed_item = stack.removeBottom();
		if (stack.isEmpty()) {
			stacks.remove(index);
		} else if (stacks.size() > index + 1) {
			int v = leftShift(index + 1, false);
			stack.push(v);
		}
		return removed_item;
	}
}

class Stack {
	private int capacity;
	public Node top, bottom;
	public int size = 0;

	public Stack(int capacity) {
		this.capacity = capacity;
	}

	public boolean isAtCapacity() {
		return capacity == size;
	}

	public void join(Node above, Node below) {
		if (below != null)
			below.above = above;
		if (above != null)
			above.below = below;
	}

	public boolean push(int v) {
		if (size >= capacity)
			return false;
		size++;
		Node n = new Node(v);
		if (size == 1)
			bottom = n;
		join(n, top);
		top = n;
		return true;
	}

	public int pop() {
		Node t = top;
		top = top.below;
		size--;
		return t.value;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int removeBottom() {
		Node b = bottom;
		bottom = bottom.above;
		if (bottom != null)
			bottom.below = null;
		size--;
		return b.value;
	}
}

class Node {

	Node below;
	Node above;
	int value;

	public Node(int v) {
		this.value = v;
	}

}
