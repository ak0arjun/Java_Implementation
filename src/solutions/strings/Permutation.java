package solutions.strings;

import solutions.TestCaseAbstract;

public class Permutation extends TestCaseAbstract {

	@Override
	public void run() {
		printPermutations("abc");

		printPermutations("12345");
	}

	private void printPermutations(String str) {
		System.out.println("Permuntations of string:" + str);
		findPermutations("", str);
		System.out.println("======Permuntations end======");
	}
	
	private void findPermutations(String perm, String options) {
		if(options.length() == 0) {
			System.out.println(perm);
		}
		for(int index=0; index<options.length();index++) {
			char option = options.charAt(index);
			findPermutations(perm + option, options.substring(0, index) + options.substring(index+1));
		}
	}
}
