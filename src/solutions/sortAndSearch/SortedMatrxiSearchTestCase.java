package solutions.sortAndSearch;

import java.util.ArrayList;

import solutions.TestCaseAbstract;

public class SortedMatrxiSearchTestCase extends TestCaseAbstract {
	
	protected ArrayList<ArrayList<Integer>> matrix;
	
	protected void generateTestCase1() {
		matrix = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> row1 = new ArrayList<Integer>();
		row1.add(15);
		row1.add(20);
		row1.add(70);
		row1.add(85);
		matrix.add(row1);
		ArrayList<Integer> row2 = new ArrayList<Integer>();
		row2.add(20);
		row2.add(35);
		row2.add(80);
		row2.add(95);
		matrix.add(row2);
		ArrayList<Integer> row3 = new ArrayList<Integer>();
		row3.add(30);
		row3.add(55);
		row3.add(95);
		row3.add(105);
		matrix.add(row3);
		ArrayList<Integer> row4 = new ArrayList<Integer>();
		row4.add(40);
		row4.add(80);
		row4.add(120);
		row4.add(120);
		matrix.add(row4);
	}

	@Override
	public void run() {
		generateTestCase1();
		SortedMatrixSearch<Integer> sortedMatrixSearch = new SortedMatrixSearch<Integer>(matrix);
		
		System.out.println("matrix:"+ matrix+" : Find matrix 55:" + sortedMatrixSearch.binarySearch(55));
		System.out.println("matrix:"+ matrix+" : Find matrix 85:" + sortedMatrixSearch.binarySearch(85));
		System.out.println("matrix:"+ matrix+" : Find matrix 35:" + sortedMatrixSearch.binarySearch(35));
		System.out.println("matrix:"+ matrix+" : Find matrix 105:" + sortedMatrixSearch.binarySearch(105));

	}

}
