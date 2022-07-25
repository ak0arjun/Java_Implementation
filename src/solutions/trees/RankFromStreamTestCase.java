package solutions.trees;

import java.util.ArrayList;

import solutions.TestCaseAbstract;
import solutions.sortAndSearch.RankFromStream;

public class RankFromStreamTestCase extends TestCaseAbstract {

	protected ArrayList<Integer> generateTestCase1(){
		ArrayList<Integer> input = new ArrayList<Integer>();
		input.add(5);
		input.add(1);
		input.add(4);
		input.add(4);
		input.add(5);
		input.add(9);
		input.add(7);
		input.add(13);
		input.add(3);
		return input;
	}
	
	@Override
	public void run() {

		RankFromStream<Integer> rankFromStream = new RankFromStream<Integer>();
		ArrayList<Integer> input1 = generateTestCase1();
		for(int li=0;li<input1.size();li++) {
			rankFromStream.track(input1.get(li));
		}
		System.out.println("Input:"+input1+" trace 1 :" + rankFromStream.trace(1));
		System.out.println("Input:"+input1+" trace 3 :" + rankFromStream.trace(3));
		System.out.println("Input:"+input1+" trace 4 :" + rankFromStream.trace(4));
		System.out.println("Input:"+input1+" trace 5 :" + rankFromStream.trace(5));
		System.out.println("Input:"+input1+" trace 7 :" + rankFromStream.trace(7));
		System.out.println("Input:"+input1+" trace 9 :" + rankFromStream.trace(9));
		System.out.println("Input:"+input1+" trace 13 :" + rankFromStream.trace(13));
	}

}
