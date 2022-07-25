package solutions.recursionAndDynamicProgramming;

import dataStructures.stack.Stack;
import solutions.TestCaseAbstract;

public class TowerOfHanoi extends TestCaseAbstract{

	protected Stack<Integer> tower1, tower2, tower3;

	protected void moveDisks(int n) {
		tower1 = new Stack<Integer>(null);
		tower1.label ="Tower 1";
		tower2 = new Stack<Integer>(null);
		tower2.label ="Tower 2";
		tower3 = new Stack<Integer>(null);
		tower3.label ="Tower 3";
		for(int i=n;i>0;i--) {
			tower1.push(i);
		}
		moveDiskRecursive(n, tower1, tower3, tower2);
	}
	
	protected void moveDiskRecursive(int n, Stack<Integer> from, Stack<Integer> to, Stack<Integer> buffer) {
		if(n<1) {
			return;
		}
		if(n==1) {
			System.out.println("Move disk " +from.peek()+ " from "+ from.label +" to " + to.label);
			to.push(from.pop());
		}else {
			moveDiskRecursive(n-1, from, buffer, to);
			System.out.println("Move disk " +from.peek()+ " from "+ from.label +" to " + to.label);
			to.push(from.pop());
			moveDiskRecursive(n-1, buffer, to, from);
		}
		
	}


	@Override
	public void run() {

		System.out.println("Move 1 disks" );
		moveDisks(1);

		System.out.println("Move 2 disks" );
		moveDisks(2);

		System.out.println("Move 3 disks" );
		moveDisks(3);


		System.out.println("Move 4 disks" );
		moveDisks(4);


	}

}
