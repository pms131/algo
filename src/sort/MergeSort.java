package sort;

import java.util.ArrayList;

public class MergeSort extends Sort {

	private ArrayList<Integer> sortArray = new ArrayList<Integer>();
	private ArrayList<Integer> tmpArray = new ArrayList<Integer>();

	public MergeSort() {
		System.out.println("## 병합 정렬 시작 ##");
	}

	@Override
	protected ArrayList<Integer> doSort(ArrayList<Integer> array) {
		int left = 0;
		int right = array.size();
		int mid = (left + right) / 2;

		doMergeSort(array, left, mid);
		doMergeSort(array, mid + 1, right);

		return array;
	}

	
	private void doMergeSort(ArrayList<Integer> array, int left, int right) {

		if (left < right) {
			int mid = (left + right) / 2;

			doMergeSort(array, left, right);
			doMergeSort(array, mid + 1, right);
			
			int pl = left;
			int pr = mid + 1;
		    int idx = pl;
		        
			
			while (pl <= mid || pr <= right) {
				if (pr > right || (pl <= mid && array.get(pl) < array.get(pr))) {
					tmpArray.set(idx++, array.get(pl++));
				} else {
					tmpArray.set(idx++, array.get(pr++));
				}
			}
			
			for (int i = left; i <= right; i++) {
				tmpArray.set(i, array.get(i));
			}
		}
	}

	public ArrayList<Integer> getSortArray() {
		return sortArray;
	}

	public void setSortArray(int idx, int value) {
		this.sortArray.set(idx, value);
	}

	public ArrayList<Integer> getTmpArray() {
		return tmpArray;
	}

	public void setTmpArray(int idx, int value) {
		this.tmpArray.set(idx, value);
	}
	
	

}