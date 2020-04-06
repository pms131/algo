package sort;

import java.util.ArrayList;

/**
 * 퀵 정렬
 * 
 * @category : 정렬
 * @param : array
 *
 */
public class QuickSort extends Sort {
	public QuickSort() {
		System.out.println("## 퀵 정렬 시작 ##");
	}

	@Override
	protected ArrayList<Integer> doSort(ArrayList<Integer> array) {
		int left = 0;
		int right = array.size() -1;	
		
		recursiveQuickSort(array, left, right);		
		
		return array;
	}
	
	
	/**
	 * 재귀를 활용한 퀵 정렬
	 * 
	 * @param array
	 * @param left
	 * @param right
	 */
	private void recursiveQuickSort(ArrayList<Integer> array, int left, int right) {
		int pl = left;
		int pr = right;
		int pivot = (pl + pr) / 2;	
				
		do {
			while (array.get(pl) < array.get(pivot))
				pl++;
			while (array.get(pr) > array.get(pivot))
				pr--;			

			if(pl <= pr)
				swap(array, pl++, pr--);
			
		} while (pl <= pr);
		
		if (pl < right)
			recursiveQuickSort(array, pl, right);
		if (pr > left)
			recursiveQuickSort(array, left, pr);
		
	}
	
}


