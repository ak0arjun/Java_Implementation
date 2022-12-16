package solutions.recursionAndDynamicProgramming;

import java.util.HashMap;
import java.util.Map;

import solutions.TestCaseAbstract;

public class CoinCominations extends TestCaseAbstract {


	public Integer countCoinCombination(int total) {
		int[] denoms = {1,5,10,25};
		HashMap<String, Integer> mem = new HashMap<String, Integer>(); 
		return countCoinCombinationRec(total, denoms, 0, mem);
	}

	protected Integer countCoinCombinationRec(int total, int[] denoms,  int index,HashMap<String, Integer> mem ) {
		if(index>denoms.length-1) {
			return 0;
		}
		if(mem.containsKey(""+total+index)) {
			return mem.get(""+total+index);
		}
		
		if(total==0) {
			return 1;
		}
		int ways =0;
		int denomAmt = denoms[index];
		for(int li=0;li*denomAmt<=total;li++) {
			int totalRemaining = total - li*denomAmt;
			ways += countCoinCombinationRec(totalRemaining, denoms, index+1,mem);
		}
		mem.put(""+total+index, ways);
		return ways;
	}

	@Override
	public void run() {

		System.out.println("Steps count possible for steps 0:" + countCoinCombination(0));
		System.out.println("Steps count possible for steps 3:" + countCoinCombination(3));
		System.out.println("Steps count possible for steps 5:" + countCoinCombination(5));
		System.out.println("Steps count possible for steps 7:" + countCoinCombination(7));
		System.out.println("Steps count possible for steps 10:" + countCoinCombination(10));
		System.out.println("Steps count possible for steps 11:" + countCoinCombination(11));
		System.out.println("Steps count possible for steps 15:" + countCoinCombination(15));
		System.out.println("Steps count possible for steps 20:" + countCoinCombination(20));
		System.out.println("Steps count possible for steps 25:" + countCoinCombination(25));
		System.out.println("Steps count possible for steps 48:" + countCoinCombination(48));

	}

}
