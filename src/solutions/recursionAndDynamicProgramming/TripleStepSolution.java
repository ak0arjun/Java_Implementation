package solutions.recursionAndDynamicProgramming;

import java.util.HashMap;
import java.util.Map;

import solutions.TestCaseAbstract;

/**
 * Calculate and return count of all possible ways one can run up stairs using hop of 1,2,3
 * @author root
 *
 */
public class TripleStepSolution extends TestCaseAbstract {

	Map<Integer, Integer> memoziation = new HashMap<Integer, Integer>(); 
	
	public Integer countPossibleSteps(int steps) {
		Integer stepCount = 0;
		stepCount = countPossibleStepsRec(steps);
		return stepCount;
	}
	
	protected Integer countPossibleStepsRec(int steps) {
		if(steps<=0) {
			return 0;
		}
		if(memoziation.containsKey(steps)) {
			return memoziation.get(steps);
		}
		Integer count = 1 + countPossibleSteps(steps-1) +countPossibleSteps(steps-2) +countPossibleSteps(steps-3);
		memoziation.put(steps, count);
		return count;
	}

	@Override
	public void run() {

		System.out.println("Steps count possible for steps 0:" + countPossibleSteps(0));
		System.out.println("Steps count possible for steps 1:" + countPossibleSteps(1));
		System.out.println("Steps count possible for steps 2:" + countPossibleSteps(2));
		System.out.println("Steps count possible for steps 3:" + countPossibleSteps(3));
		System.out.println("Steps count possible for steps 4:" + countPossibleSteps(4));
		System.out.println("Steps count possible for steps 5:" + countPossibleSteps(5));
		System.out.println("Steps count possible for steps 6:" + countPossibleSteps(6));
		System.out.println("Steps count possible for steps 7:" + countPossibleSteps(7));
		
	}
}
