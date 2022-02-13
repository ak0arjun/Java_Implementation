package solutions.standardMethods;

import java.util.ArrayList;
import java.util.List;

public class Helpers<T extends Comparable<T>> {

	public Integer placeElementInCorrectPosition(List<T> inputs, T val,  Integer si, Integer ei) {
		Integer pos = -1;
		if(inputs!=null) {
			Integer ptr1 = si;
			Integer ptr2 = ei;
			while(ptr1<ptr2) {
				boolean isChanged = false;
				while(inputs.get(ptr1).compareTo(val) < 0) {
					ptr1++;
					isChanged = true;
				}
				while( inputs.get(ptr2).compareTo(val) > 0) {
					ptr2--;
					isChanged = true;
				}
				if(ptr1<ptr2) {
					T temp = inputs.get(ptr1);
					inputs.set(ptr1, inputs.get(ptr2));
					inputs.set(ptr2, temp);
				}
				if(!isChanged) {
					break;
				}
			}
			if(ptr1 == ptr2) {
				pos = ptr1;	
			}
			else if(inputs.get(ptr1)==val) {
				pos = ptr1;
			}else {
				pos = ptr2;
			}
		}
		return pos;
	}

	public void mergeSortedArray(List<T> inputs, Integer si1, Integer ei1, Integer si2, Integer ei2) {
//		System.out.println("inputs:"+inputs+":"+si1+":"+ei1+":"+si2+":"+ei2);
		if(inputs!=null) {
			if(si1<=ei1 && si2<=ei2 && ei1<si2) {
				List<T> newArray = new ArrayList<T>();
				int ptr1 = si1;
				int ptr2 = si2;
				while(ptr1<=ei1 || ptr2<=ei2) {
					if(ptr1>ei1) {
						newArray.add(inputs.get(ptr2));
						ptr2++;
					}
					else if(ptr2>ei2) {
						newArray.add(inputs.get(ptr1));
						ptr1++;
					}else {
						if(inputs.get(ptr1).compareTo(inputs.get(ptr2))<0) {
							newArray.add(inputs.get(ptr1));
							ptr1++;
						}else {
							newArray.add(inputs.get(ptr2));
							ptr2++;
						}
					}
				}

				Integer count =0;
				for(int li=si1;li<=ei1;li++) {
					inputs.set(li, newArray.get(count));
					count++;
				}

				for(int li=si2;li<=ei2;li++) {
					inputs.set(li, newArray.get(count));
					count++;
				}
//				System.out.println("newArray:"+newArray+":"+ "inputs:"+inputs+":"+si1+":"+ei1+":"+si2+":"+ei2);
			}
		}
	}

}
