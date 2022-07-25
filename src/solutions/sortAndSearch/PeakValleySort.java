package solutions.sortAndSearch;

import java.util.ArrayList;

/**
 * Sort an array in such a manner that each element represent a peak and valley patter in the given array.
 * An element is called peak if it is greater than or equal to its adjacent elements
 * An element is called valley if it is less than or equal to its adjacent elements
 * @author root
 *
 * @param <T>
 */
public class PeakValleySort<T extends Comparable<T>> {

	public PeakValleySort() {
	}

	/**
	 * It sorts the given array in peak valley fashion
	 * @param input
	 */
	public void sort(ArrayList<T> input) {
		if(input != null && input.size()>1) {
			for (int li=1;li<input.size();li=li+2) {
				T leftElement = null;
				T element = input.get(li);
				T rightElement = null;
				if(li<input.size()-1) {
					rightElement = input.get(li+1);
				}
				if(li>0) {
					leftElement = input.get(li-1);
				}
				if(leftElement != null && rightElement!=null) {
					if(leftElement.compareTo(rightElement)>0) {
						if(leftElement.compareTo(element)>0) {
							swapElements(li-1, li, input);
						}
					}else {
						if(rightElement.compareTo(element)>0) {
							swapElements(li+1, li, input);
						}
					}
				}else if( leftElement==null && rightElement!=null) {
					if(rightElement.compareTo(element)>0) {
						swapElements(li+1, li, input);
					}
				}else if( leftElement!=null && rightElement==null) {
					if(leftElement.compareTo(element)>0) {
						swapElements(li-1, li, input);
					}
				}
			}
		}
	}
	
	protected void swapElements(int ptr1, int ptr2, ArrayList<T> input) {
		T temp = input.get(ptr1);
		input.set(ptr1, input.get(ptr2));
		input.set(ptr2, temp);
	}
}
