package sort;

import java.util.ArrayList;

/**
 * 삽입 정렬
 * 
 * @category : 정렬
 * @param :
 *            array
 *
 */
public class InsertSort extends Sort {

	public InsertSort() {
		System.out.println("## 삽입 정렬 시작 ##");
	}

	@Override
	protected ArrayList<Integer> doSort(ArrayList<Integer> array) {
		for (int i = 1; i < array.size(); i++) {
			// 선택 데이터
			int key = array.get(i);
			//비교 데이터
			int j = i - 1;

			// 이전의 원소가 더 크다면 데이터는 하나씩 밀려난다.
			while (j >= 0 && array.get(j) > key) {
				array.set(j + 1, array.get(j));
				j--;
			}
			array.set(j + 1, key);
		}
		return array;
	}

}
