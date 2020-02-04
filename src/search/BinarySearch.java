package search;

import java.util.ArrayList;

public class BinarySearch extends Search {
	
	public BinarySearch() {
		System.out.println("## 이진 검색 시작 ##");
	}
	
	@Override
	protected int doSearch(ArrayList<Integer> array, int idx, int key) {
		int start = 0;
		int end = idx - 1;
				
		do {
			int mid = (start + end) / 2;
			
			if (key == array.get(mid)) {
				return mid + 1;
			} else if (key > array.get(mid)) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		} while (start <= end) ;
				
		return -1;
	}
	
	void test () {
		
	}
}
