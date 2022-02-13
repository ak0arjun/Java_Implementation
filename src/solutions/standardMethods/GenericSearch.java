package solutions.standardMethods;

import java.util.List;

/**
 * A generic class implementation of search algorithm like :
 * binary search on sorted List
 * Kth element search on unsorted List
 * @author root
 *
 * @param <T>
 */
public class GenericSearch<T extends Comparable<T>> {

	Helpers<T> helpers = new Helpers<T>();


	/**
	 * For the given sorted list it returns pos if the given value exists else return -1
	 * @param inputs
	 * @return
	 */
	public Integer binarySearch(List<T> inputs, T val) {
		Integer retPos = -1;
		int mid = (inputs.size()-1)/2;
		int lastFound = -1;
		while(mid>=0 && mid < inputs.size()) {
			if(inputs.get(mid).compareTo(val)==0) {
				retPos = mid;
				break;
			}else if(inputs.get(mid).compareTo(val)>0){
				mid = (mid-1)/2;
			}else {
				mid = (mid + inputs.size())/2;
			}
			if(lastFound==mid) {
				break;
			}else {
				lastFound = mid;
			}
		}
		return retPos;
	}

	/**
	 * It finds the Kth element on the given list of unique element using Quick sort technique
	 * @param inputs
	 * @param k
	 * @return
	 */
	public T findKthSortedElement(List<T> inputs, Integer k) {
		T retVal = null;
		int currPos = -1;
		if(inputs!=null && inputs.size()>0 && k<inputs.size()) {
			T valPosToFind = inputs.get((inputs.size()-1)/2);
			int count=0;
			while(currPos!=k && count<inputs.size()) {
				currPos =  helpers.placeElementInCorrectPosition(inputs, valPosToFind, 0, inputs.size()-1);
				if(currPos ==k) {
					retVal = inputs.get(currPos);
					break;
				}else {
					if(currPos>k) {
						valPosToFind = inputs.get((currPos-1)/2);
					}else {
						valPosToFind = inputs.get((currPos+inputs.size())/2);
					}
				}
				count++;
			}
		}
		return retVal;
	}

}
