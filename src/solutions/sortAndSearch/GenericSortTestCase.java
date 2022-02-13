package solutions.sortAndSearch;

import java.util.ArrayList;
import java.util.List;

import solutions.TestCaseAbstract;
import solutions.standardMethods.GenericSort;

public class GenericSortTestCase  extends TestCaseAbstract{

	
	protected List<Integer> generateTestCase1(){
		List<Integer> inputs = new ArrayList<Integer>();
		
		inputs.add(2);
		inputs.add(1);
		inputs.add(6);
		inputs.add(10);
		inputs.add(4);
		inputs.add(1);
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
		List<Integer> input1a = generateTestCase1(); 
		sort.bubbleSort(input1a);
		List<Integer> input1b = generateTestCase1(); 
		sort.selectionSort(input1b);
		List<Integer> input1c = generateTestCase1(); 
		sort.quickSort(input1c);
		List<Integer> input1d = generateTestCase1(); 
		sort.mergeSort(input1d);
		
		System.out.println("input1a:"+input1a);
		System.out.println("input1b:"+input1b);
		System.out.println("input1c:"+input1c);
		System.out.println("input1d:"+input1d);
		
		List<Integer> input2a = generateTestCase2(); 
		sort.bubbleSort(input2a);
		List<Integer> input2b = generateTestCase2(); 
		sort.selectionSort(input2b);
		List<Integer> input2c = generateTestCase2(); 
		sort.quickSort(input2c);
		List<Integer> input2d = generateTestCase2(); 
		sort.mergeSort(input2d);
		
		System.out.println("input2a:"+input2a);
		System.out.println("input2b:"+input2b);
		System.out.println("input2c:"+input2c);
		System.out.println("input2d:"+input2d);
		
		List<Integer> input3a = generateTestCase3(); 
		sort.bubbleSort(input3a);
		List<Integer> input3b = generateTestCase3(); 
		sort.selectionSort(input3b);
		List<Integer> input3c = generateTestCase3(); 
		sort.quickSort(input3c);
		List<Integer> input3d = generateTestCase3(); 
		sort.mergeSort(input3d);
		
		System.out.println("input3a:"+input3a);
		System.out.println("input3b:"+input3b);
		System.out.println("input3c:"+input3c);
		System.out.println("input3d:"+input3d);
		
		List<Integer> input4a = generateTestCase4(); 
		sort.bubbleSort(input4a);
		List<Integer> input4b = generateTestCase4(); 
		sort.selectionSort(input4b);
		List<Integer> input4c = generateTestCase4(); 
		sort.quickSort(input4c);
		List<Integer> input4d = generateTestCase4(); 
		sort.mergeSort(input4d);
		
		System.out.println("input4a:"+input4a);
		System.out.println("input4b:"+input4b);
		System.out.println("input4c:"+input4c);
		System.out.println("input4d:"+input4d);
		
		List<Integer> input5a = generateTestCase5(); 
		sort.bubbleSort(input5a);
		List<Integer> input5b = generateTestCase5(); 
		sort.selectionSort(input5b);
		List<Integer> input5c = generateTestCase5(); 
		sort.quickSort(input5c);
		List<Integer> input5d = generateTestCase5(); 
		sort.mergeSort(input5d);
		
		System.out.println("input5a:"+input5a);
		System.out.println("input5b:"+input5b);
		System.out.println("input5c:"+input5c);
		System.out.println("input5d:"+input5d);
		
	}

	
}
