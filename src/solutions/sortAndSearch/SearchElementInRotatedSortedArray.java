package solutions.sortAndSearch;

import java.util.List;


public class SearchElementInRotatedSortedArray<T extends Comparable<T>>  {

	public int execute(List<T> input, T element) {
		int index = -1;

		if(input!=null && input.size()>0) {
			index =searchList(input, 0, input.size()-1, element);
		}

		return index;
	}

	protected int searchList(List<T> input, int si, int ei, T element) {

		if(si>ei) {
			return -1;
		}
		int mid = (si+ei)/2;
		if(input.get(mid).compareTo(element) == 0) {
			return mid;
		}

		if(input.get(si).compareTo(input.get(mid)) <0) {
			if(input.get(mid).compareTo(element) >0 && input.get(si).compareTo(element)<=0) {
				return searchList(input, si, mid-1, element);		
			}else {
				return searchList(input,mid+1, ei, element);
			}
		}else if(input.get(ei).compareTo(input.get(mid)) >0) {
			if(input.get(mid).compareTo(element) <0 && input.get(ei).compareTo(element)>=0) {
				return searchList(input, mid+1, ei, element);		
			}else {
				return searchList(input, si, mid-1, element);	
			}
		}else {
			if(input.get(si).compareTo(input.get(mid)) == 0) {
				if(input.get(ei).compareTo(input.get(mid))!=0) {
					return searchList(input, mid+1, ei, element);		
				}else {
					int search = searchList(input, si, mid-1, element);	
					if(search ==-1) {
						search =  searchList(input, mid+1, ei, element);
					}
					return search;
				}
			}
		}
		return -1;
	}

}
