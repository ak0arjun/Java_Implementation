package solutions.sortAndSearch;

import java.util.ArrayList;

import solutions.TestCaseAbstract;

public class SearchElementInRotatedSortedArrayTestCase extends TestCaseAbstract {


	private ArrayList<Integer> generateTestCase1(){
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(15);
		result.add(16);
		result.add(19);
		result.add(20);
		result.add(25);
		result.add(1);
		result.add(3);
		result.add(4);
		result.add(5);
		result.add(7);
		result.add(10);
		result.add(14);

		return result;
	}

	private ArrayList<Integer> generateTestCase2(){
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(10);
		result.add(15);
		result.add(20);
		result.add(20);
		result.add(0);
		result.add(5);

		return result;
	}

	private ArrayList<Integer> generateTestCase3(){
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(50);
		result.add(5);
		result.add(20);
		result.add(20);
		result.add(30);
		result.add(40);

		return result;
	}

	private ArrayList<Integer> generateTestCase4(){
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(2);
		result.add(2);
		result.add(2);
		result.add(3);
		result.add(4);
		result.add(2);

		return result;
	}

	@Override
	public void run() {
		SearchElementInRotatedSortedArray<Integer> searchElementInRotatedSortedArray = new SearchElementInRotatedSortedArray<Integer>();

		ArrayList<Integer> input = generateTestCase1();

		int pos = searchElementInRotatedSortedArray.execute(input, 5);
		System.out.println("Input:" +input + "element:"+ 5+ " res pos:"+pos);

		input = generateTestCase2();

		pos = searchElementInRotatedSortedArray.execute(input, 5);
		System.out.println("Input:" +input + "element:"+ 5+ " res pos:"+pos);

		input = generateTestCase3();

		pos = searchElementInRotatedSortedArray.execute(input, 5);
		System.out.println("Input:" +input + "element:"+ 5+ " res pos:"+pos);

		input = generateTestCase4();

		pos = searchElementInRotatedSortedArray.execute(input, 4);
		System.out.println("Input:" +input + "element:"+ 4+ " res pos:"+pos);
	}

}
