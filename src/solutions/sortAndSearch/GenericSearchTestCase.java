package solutions.sortAndSearch;

import java.util.ArrayList;
import java.util.List;

import solutions.standardMethods.GenericSearch;
import solutions.standardMethods.GenericSort;

public class GenericSearchTestCase extends solutions.TestCaseAbstract{
	
	
	protected List<Integer> generateTestCase1(){
		List<Integer> inputs = new ArrayList<Integer>();
		
		inputs.add(2);
		inputs.add(1);
		inputs.add(6);
		inputs.add(10);
		inputs.add(4);
		inputs.add(11);
		inputs.add(3);
		inputs.add(9);
		inputs.add(7);
		
		return inputs;
	}
	
	protected List<Integer> generateTestCase2(){
		List<Integer> inputs = new ArrayList<Integer>();
		return inputs;
	}
	
	protected List<Integer> generateTestCase3(){
		List<Integer> inputs = new ArrayList<Integer>();
		
		inputs.add(5);
		
		return inputs;
	}
	
	protected List<Integer> generateTestCase4(){
		List<Integer> inputs = new ArrayList<Integer>();
		
		inputs.add(1);
		inputs.add(2);
		inputs.add(3);
		inputs.add(4);
		inputs.add(5);
		
		return inputs;
	}
	
	protected List<Integer> generateTestCase5(){
		List<Integer> inputs = new ArrayList<Integer>();
		
		inputs.add(5);
		inputs.add(4);
		inputs.add(3);
		inputs.add(2);
		inputs.add(1);
		
		return inputs;
	}

	@Override
	public void run() {
		
		GenericSort<Integer> sort = new GenericSort<Integer>();
		GenericSearch<Integer> genericSearch = new GenericSearch<Integer>();
		
		List<Integer> input1a = generateTestCase1(); 
		sort.quickSort(input1a);
		List<Integer> input1b = generateTestCase1(); 
		
		System.out.println("Binary search 6:" +input1a+":" +genericSearch.binarySearch(input1a, 6));
		System.out.println("Find element 3:" +input1b+":"+genericSearch.findKthSortedElement(input1b, 3)+":"+input1b);
		
		List<Integer> input2a = generateTestCase2(); 
		sort.quickSort(input2a);
		List<Integer> input2b = generateTestCase2(); 
		
		System.out.println("Binary search 5:" +input2a+":"+genericSearch.binarySearch(input2a, 5));
		System.out.println("Find element 0:" +input2b+":"+genericSearch.findKthSortedElement(input2b, 0));
		
		List<Integer> input3a = generateTestCase3(); 
		sort.quickSort(input3a);
		List<Integer> input3b = generateTestCase3(); 
		
		System.out.println("Binary search 6:"+input3a+":" +genericSearch.binarySearch(input3a, 6));
		System.out.println("Binary search 5:"+input3a+":" +genericSearch.binarySearch(input3a, 5));
		System.out.println("Find element 3:"+input3b+":" +genericSearch.findKthSortedElement(input3b, 3));
		System.out.println("Find element 0:"+input3b+":" +genericSearch.findKthSortedElement(input3b, 0));
		
		List<Integer> input4a = generateTestCase4(); 
		sort.quickSort(input4a);
		List<Integer> input4b = generateTestCase4(); 
		
		System.out.println("Binary search 3:"+input4a+":" +genericSearch.binarySearch(input4a, 3));
		System.out.println("Find element 4:" +input4b+":"+genericSearch.findKthSortedElement(input4b, 3));
		
		List<Integer> input5a = generateTestCase5(); 
		sort.quickSort(input5a);
		List<Integer> input5b = generateTestCase5(); 
		
		System.out.println("Binary search 3:"+input5a+":" +genericSearch.binarySearch(input1b, 3));
		System.out.println("Find element 4:" +input5b+":"+genericSearch.findKthSortedElement(input1b, 3));
	}

}
