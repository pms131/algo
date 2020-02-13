package sort;

import java.util.ArrayList;

/**
 * 버블 정렬
 * 
 * @category : 정렬
 * @param : array
 *
 */

public class BubbleSort extends Sort{

	public BubbleSort() {
		System.out.println("## 버블 정렬 시작 ##");
	}
	
	@Override
	protected ArrayList<Integer> doSort(ArrayList<Integer> array) {
		
		for (int i = 0; i < array.size() - 1; i++) {
			for (int j = array.size() -1 ; j > i ; j--) {
				if (array.get(j) < array.get(j-1))
					swap(array, j, j-1);
			}
		}
		
		
		return array;
	}
	
}
