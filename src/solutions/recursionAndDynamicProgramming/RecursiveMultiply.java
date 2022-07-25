package solutions.recursionAndDynamicProgramming;

import solutions.TestCaseAbstract;

public class RecursiveMultiply extends TestCaseAbstract{
	
	/**
	 * Multiply 2 numbers without using multiplication operation
	 * @param a Bigger number
	 * @param b Smaller number
	 * @return a*b
	 */
	public int recursiveMultiply(int a, int b) {
		if(a == 1) {
			return b;
		}if(a<1) {
			return 0;
		}
		
		int c = a/2;
		if(a%2 ==0) {
			int result = recursiveMultiply(c, b);
			return result + result;
		}else {
			int result = recursiveMultiply(c, b);
			return result + result + b;
		}
	}

	@Override
	public void run() {
	
		System.out.println("5*6=" + recursiveMultiply(6, 5));

		System.out.println("5*7=" + recursiveMultiply(7, 5));
		
	}

}
