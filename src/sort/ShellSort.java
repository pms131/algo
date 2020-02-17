package sort;

import java.util.ArrayList;

/**
 * 쉘 정렬
 * 
 * @category : 정렬
 * @param : array
 * 삽입 정렬을 보안한 정렬 알고리즘 ( 삽입되어야 할 위치가 현재 위치에서 상당히 멀리 떨어진 곳이라면 많은 이동을 해야 하는 점 보안)
 *
 */
public class ShellSort extends Sort {
	
	public ShellSort() {
		System.out.println("## 쉘 정렬 시작 ##");
	}
	
	protected ArrayList<Integer> insertSort(ArrayList<Integer> array, int key) {

		for (int i = 0; i < array.size() - 1; i+=key) {
			int tmp = array.get(i + key);
			for (int j = i + key; j >= 0; j-=key) {
				if (j == 0 || array.get(j - key) <= tmp) {
					array.set(j, tmp);
					break;
				} else {
					array.set(j, array.get(j - key));
				}
			}
		}

		return array;
	}
	

	@Override
	protected ArrayList<Integer> doSort(ArrayList<Integer> array) {
		
		
		for (int key = array.size() / 2; key > 0; key /= 2) {
			if ( (key % 2) == 0)			//짝수일 경우
				key++;
			
			for (int j = 0; j < key; j ++) {
				insertSort(array, key);
			}
		}
		return array;
	}

}
