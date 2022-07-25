package solutions.sortAndSearch;

import java.util.ArrayList;

import solutions.TestCaseAbstract;

public class SparseSearchTestCase extends TestCaseAbstract {
	
	protected  ArrayList<String> generateTestcase1(){
		ArrayList<String> input = new ArrayList<String>();
		input.add((String) "at");
		input.add((String) "");
		input.add((String) "");
		input.add((String) "");
		input.add((String) "ball");
		input.add((String) "");
		input.add((String) "");
		input.add((String) "car");
		input.add((String) "");
		input.add((String) "");
		input.add((String) "dad");
		input.add((String) "");
		input.add((String) "");
		
		return input;
		
	}
	
	protected  ArrayList<String> generateTestcase2(){
		ArrayList<String> input = new ArrayList<String>();
		input.add((String) "at");
		input.add((String) "");
		input.add((String) "");
		input.add((String) "");
		input.add((String) "");
		input.add((String) "");
		input.add((String) "");
		input.add((String) "");
		input.add((String) "");
		input.add((String) "");
		input.add((String) "");
		input.add((String) "");
		input.add((String) "dad");
		
		return input;
		
	}

	protected  ArrayList<String> generateTestcase3(){
		ArrayList<String> input = new ArrayList<String>();
		input.add((String) "at");
		input.add((String) "");
		input.add((String) "");
		input.add((String) "");
		input.add((String) "");
		input.add((String) "");
		input.add((String) "ball");
		input.add((String) "");
		input.add((String) "");
		input.add((String) "");
		input.add((String) "");
		input.add((String) "");
		input.add((String) "dad");
		
		return input;
		
	}
	
	@Override
	public void run() {
		ArrayList<String> input1 = generateTestcase1();
		SparseSearch<String> sparseSearch = new SparseSearch<String>();
		int index= sparseSearch.execute(input1, "", "ball");
		System.out.println("input:"+input1+", search ball result="+index);
		
		input1 = generateTestcase2();
		index= sparseSearch.execute(input1, "", "at");
		System.out.println("input:"+input1+", search at result="+index);
		
		input1 = generateTestcase2();
		index= sparseSearch.execute(input1, "", "dad");
		System.out.println("input:"+input1+", search dad result="+index);
		
		input1 = generateTestcase3();
		index= sparseSearch.execute(input1, "", "ball");
		System.out.println("input:"+input1+", search ball result="+index);
	}

}
