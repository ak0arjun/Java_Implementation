package solutions.stack;

import dataStructures.stack.Stack;
import solutions.TestCaseAbstract;

public class SortStackUsingStack extends TestCaseAbstract{

	@Override
	public void run() {
		Stack<Integer> stk1 = new Stack<Integer>(1);
		stk1.push(5);
		stk1.push(4);
		stk1.push(2);
		stk1.push(3);
		stk1.push(6);
		stk1.printStack();
		sortStack(stk1);
		stk1.printStack();
		
		Stack<Integer> stk2 = new Stack<Integer>(1);
		stk2.printStack();
		sortStack(stk2);
		stk2.printStack();
		
		Stack<Integer> stk3 = new Stack<Integer>(null);
		stk3.printStack();
		sortStack(stk3);
		stk3.printStack();
	}

	private void sortStack(Stack<Integer> stk) {
		Stack<Integer> temp = new Stack<Integer>(null);
		while (!stk.isEmpty()) {
			Integer val = stk.pop();
			while (temp.peek() !=null && temp.peek() > val) {
				stk.push(temp.pop());
			}
			temp.push(val);
		}
		while(temp.peek() != null) {
			stk.push(temp.pop());
		}
	}

}
