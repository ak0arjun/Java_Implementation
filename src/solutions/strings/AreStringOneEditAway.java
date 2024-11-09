package solutions.strings;

import solutions.TestCaseAbstract;

/**
 * It checks if given strings are one or zero edit away. 
 * There are 3 types of edits that can be performed: insert, replace, remove a character. 
 * For example (pale, ple) → true, (pale, bale) → true, (pale, ale) → true, (pale, nake) → false
 */
public class AreStringOneEditAway  extends TestCaseAbstract{

	@Override
	public void run() {
		boolean sol1 = areStringSingleEditAway("pale", "ple");
		boolean sol2 = areStringSingleEditAway("pale", "bale");
		boolean sol3 = areStringSingleEditAway("pale", "ale");
		boolean sol4 = areStringSingleEditAway("pale", "nake");
		boolean sol5 = areStringSingleEditAway("pale", "pale");
		boolean sol6 = areStringSingleEditAway("paled", "ple");
		System.out.println("pale/ple->" + sol1);
		System.out.println("pale/bale->" + sol2);
		System.out.println("pale/ale->" + sol3);
		System.out.println("pale/nake->" + sol4);
		System.out.println("pale/pale->" + sol5);
		System.out.println("paled/ple->" + sol6);
	}
	
	/**
	 * It checks if given strings are one or zero edit away. 
	 * @param str1
	 * @param str2
	 * @return
	 */
	private boolean areStringSingleEditAway(String str1, String str2) {
		int sizeDiff = str1.length()-str2.length();
		if(Math.abs(sizeDiff) > 1) {
			return false;
		}
		
		boolean foundDifference = false;
		int index1 = 0;
		int index2 = 0;
		while(index1 < str1.length() && index2 < str2.length()) {
			if (str1.charAt(index1) != str2.charAt(index2)) {
				if (foundDifference) {
					return false;
				}
				foundDifference = true;
				if (str1.length() > str2.length()) {
					index1++;
				} else if (str1.length() < str2.length()){
					index2++;
				} else {
					index1++;
					index2++;
				}
			} else {
				index1++;
				index2++;
			}
		}
		return true;
	}
}
