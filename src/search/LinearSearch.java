package search;

import java.util.ArrayList;

public class LinearSearch extends Search {
	
	public LinearSearch() {
		System.out.println("## ���� �˻� ���� ##");
	}
	
	@Override
	protected int doSearch(ArrayList<Integer> array, int idx, int key) {
		for(int i=0; i<idx; i++) {
			if (key == array.get(i))
				return i+1;
		}
		
		return -1;
	}
	
}
