package sort;

import java.util.ArrayList;

/**
 * 선택 정렬
 * 
 * @category : 정렬
 * @param : array
 *
 */
public class SelectionSort extends Sort {
	public SelectionSort() {
		System.out.println("## 선택 정렬 시작 ##");
	}

	@Override
	protected ArrayList<Integer> doSort(ArrayList<Integer> array) {
		
		for (int i = 0; i < array.size() - 1; i++) {
			int min = i;
			for (int j = i + 1; j < array.size(); j++) {
				if (array.get(min) > array.get(j))
					min = j;
			}
			swap(array, i, min);
		}
		
		return array;
	}
	
}
