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
		System.out.println("## 선택 정렬 시작 ##");
	}

	@Override
	protected ArrayList<Integer> doSort(ArrayList<Integer> array) {

		for (int i = 0; i < array.size() - 1; i++) {
			int tmp = array.get(i + 1);
			for (int j = i + 1; j >= 0; j--) {
				if (j == 0 || array.get(j - 1) <= tmp) {
					array.set(j, tmp);
					break;
				} else {
					array.set(j, array.get(j - 1));
				}
			}
		}

		return array;
	}

}
