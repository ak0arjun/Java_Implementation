package solutions.sortAndSearch;

import java.util.ArrayList;

/**
 * Perform a binary search on the given sorted matrix
 * @author root
 *
 */
public class SortedMatrixSearch<T extends Comparable<T>> {

	protected ArrayList<ArrayList<T>> matrix;

	public SortedMatrixSearch(ArrayList<ArrayList<T>> matrix) {
		this.matrix = matrix;
	}

	public ArrayList<Integer> binarySearch(T val){
		ArrayList<Integer> ret = new ArrayList<Integer>();
		recursiveBinarySearch(0, 0, matrix.size()-1, matrix.get(0).size()-1, ret, val);
		return ret;
	}

	protected void recursiveBinarySearch(int sx, int sy, int ex, int ey, ArrayList<Integer> ret, T val) {
//		System.out.println(sx+":"+sy+":"+ex+":"+ey+":"+ret.size());
		if(ret.size()>0) {
			return;
		}
		if(sx>ex || sy> ey) {
			return;
		}
		if(sx==ex && sy==ey) {
			if(matrix.get(ex).get(ey).compareTo(val)==0) {
				ret.add(ex);
				ret.add(ey);
				return;
			}
		}
		int midx = (sx+ex)/2;
		int midy = (sy+ey)/2;
		int ptr1x = sx;
		int ptr1y = sy;
		int ptr2x = ex;
		int ptr2y = ey;
		while((ptr1x<ptr2x || ptr1y<ptr2y) && ptr1x>=sx && ptr2x>=sx && ptr1x<=ex && ptr2x<=ex && ptr1y>=sy && ptr2y>=sy && ptr2y<=ey && ptr1y<=ey) {
			midx = (ptr1x+ptr2x)/2;
			midy = (ptr1y+ptr2y)/2;
			if(matrix.get(midx).get(midy).compareTo(val)==0) {
				ret.add(midx);
				ret.add(midy);
				return;
			}else {
				if(matrix.get(midx).get(midy).compareTo(val)>0) {
					ptr2x = midx -1;
					ptr2y = midy - 1;
				}else {
					ptr1x = midx + 1;
					ptr1y = midy + 1;
				}
			}
		}
		int midx2 = midx;
		int midy2 = midy;
		if(matrix.get(midx).get(midy).compareTo(val)>0) {
			midx--;
			midy--;
		}else {
			midx2++;
			midy2++;
		}
		if(midx2>=sx &&midy2<=(ey+1) && midx2<=ex && midy2>sx) {
			recursiveBinarySearch(midx2, sy, ex, midy2-1, ret, val);
		}
		if(midx>=sx &&midy<ey && midx<=ex && midy>=sy ) {
			recursiveBinarySearch(sx, midy+1,  midx,ey, ret, val);
		}
	}
}
