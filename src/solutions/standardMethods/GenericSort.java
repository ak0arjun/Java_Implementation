package solutions.standardMethods;

import java.util.List;

/**
 * A class with implementation of different sort options like:
 * Quick
 * Merge
 * Bubble
 * Selection
 * @author root
 *
 * @param <T>
 */
public class GenericSort<T extends Comparable<T>> {

	Helpers<T> helpers = new Helpers<T>();

	/**
	 * Sort the given array using bubble sort Algorithm
	 * @param inputs
	 */
	public void bubbleSort(List<T> inputs) {
		if(inputs!=null) {
			for(int ptr1=0;ptr1<inputs.size();ptr1++) {
				for( int ptr2=ptr1;ptr2<inputs.size();ptr2++) {
					if(inputs.get(ptr2).compareTo(inputs.get(ptr1))<0) {
						T temp = inputs.get(ptr2);
						inputs.set(ptr2, inputs.get(ptr1));
						inputs.set(ptr1, temp);
					}
				}
			}
		}
	}

	/**
	 * Sort the given array using selection sort Algorithm
	 * @param inputs
	 */
	public void selectionSort(List<T> inputs) {
		if(inputs!=null) {
			for(int ptr1=0;ptr1<inputs.size();ptr1++) {
				T minVal = inputs.get(ptr1);
				for( int ptr2=ptr1+1;ptr2<inputs.size();ptr2++) {
					if(minVal.compareTo(inputs.get(ptr2)) > 0) {
						T temp = inputs.get(ptr2);
						inputs.set(ptr2, inputs.get(ptr1));
						inputs.set(ptr1, temp);
						minVal  = temp;
					}
				}
			}
		}
	}

	/**
	 * Sort the given array using quick sort Algorithm
	 * @param inputs
	 */
	public void quickSort(List<T> inputs) {
		if(inputs!=null) {
			quickSortRecursion(inputs, 0, inputs.size()-1);
		}
	}

	protected void quickSortRecursion(List<T> inputs, Integer si, Integer ei) {
		if(si>=ei) {
			return;
		}

		Integer mi = (si+ei)/2;
//		System.out.println("Res:"+si+":"+ei+":"+inputs);
		mi = helpers.placeElementInCorrectPosition(inputs, inputs.get(mi), si , ei);
//		System.out.println("Res:"+si+":"+ei+":"+inputs+":"+mi);
		quickSortRecursion(inputs, si, mi-1);
		quickSortRecursion(inputs, mi+1, ei);
	}
	
	/**
	 * Sort the given array using merge sort Algorithm
	 * @param inputs
	 */
	public void mergeSort(List<T> inputs) {
		if(inputs!=null) {
			mergeSortRecurion(inputs, 0, inputs.size()-1);
		}
	}
	
	protected void mergeSortRecurion(List<T> inputs, Integer si,Integer ei) {
		if(si>=ei) {
			return;
		}
		 Integer mi = (si+ei)/2;
		 mergeSortRecurion(inputs, si, mi);
		 mergeSortRecurion(inputs, mi+1, ei);	 
		 helpers.mergeSortedArray(inputs, si, mi, mi+1, ei);
	}
	
}
