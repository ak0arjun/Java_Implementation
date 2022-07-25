package solutions.sortAndSearch;

import java.util.ArrayList;

import solutions.TestCaseAbstract;

public class PeakValleySortTestCase extends TestCaseAbstract {

	protected ArrayList<Integer> generateTestCase1(){
		ArrayList<Integer> input = new ArrayList<Integer>();
		input.add(5);
		input.add(3);
		input.add(1);
		input.add(2);
		input.add(3);
		return input;
	}
	
	protected ArrayList<Integer> generateTestCase2(){
		ArrayList<Integer> input = new ArrayList<Integer>();
		input.add(0);
		input.add(1);
		input.add(4);
		input.add(7);
		input.add(8);
		input.add(9);
		return input;
	}
	
	@Override
	public void run() {
		PeakValleySort<Integer> peakValleySort = new PeakValleySort<Integer>();
		ArrayList<Integer> input = generateTestCase1();
		System.out.println("Input :"+ input);
		peakValleySort.sort(input);
		System.out.println("Sort :"+ input );
		input = generateTestCase2();
		System.out.println("Input :"+ input);
		peakValleySort.sort(input);
		System.out.println("Sort :"+ input );
		
	}

}
