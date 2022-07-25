package solutions.sortAndSearch;

import java.util.List;

/**
 * It conducts binary search on the given list with a sparse value. 
 * @author root
 *
 * @param <T> 
 */
public class SparseSearch<T extends Comparable<T>> {
	
	/**
	 * If search value is same as sparse value it return -1. If no search value found it returns -1 else it returns index of the array
	 * @param input
	 * @param sparseVal Value to be ignored
	 * @param searchVal Value to be searched
	 * @return
	 */
	public int execute(List<T> input, T sparseVal, T searchVal){
		if(sparseVal.compareTo(searchVal)==0) {
			return -1;
		}
		int retIndex = -1;
		
		int ptr1 = 0;
		int ptr2 = input.size()-1;
		
		while(ptr1<ptr2) {
			
			int mid = findMid(input, sparseVal, 0, ptr1, ptr2);
			if(input.get(mid).compareTo(searchVal)==0) {
				return mid;
			}
			if(mid == ptr1) {
				mid = findMid(input, sparseVal, 1, ptr1, ptr2);
				if(input.get(mid).compareTo(searchVal)==0) {
					return mid;
				}
				if(mid == ptr2) {
					return -1;
				}
			}
			if(input.get(mid).compareTo(searchVal)>0) {
				ptr2 = mid-1;
			}else {
				ptr1=mid+1;
			}
		}
		
		return retIndex;
	}
	
	protected int findMid(List<T> input, T sparseVal, int type, int si, int ei) {
		int mid = (si+ei)/2;
		if(input.get(mid).compareTo(sparseVal)!=0) {
			return mid;
		}else if(type==0) {
			while(mid>si && input.get(mid).compareTo(sparseVal)==0) {
				mid--;
			}
			return mid;
		}else {
			while(mid<ei && input.get(mid).compareTo(sparseVal)==0) {
				mid++;
			}
			return mid;
		}
		
	}

}
