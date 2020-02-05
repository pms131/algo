package sort;

import java.util.ArrayList;
import java.util.Scanner;

public class SortingTestMain {

	public static void main(String[] args) {

		int idx, key;

		System.out.print("배열의 크기 : ");

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		idx = sc.nextInt();

		ArrayList<Integer> array = new ArrayList<>();
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < idx; i++) {
			array.add(sc.nextInt());

			sb.append(array.get(i));

			if (i != idx - 1)
				sb.append(", ");
			else
				System.out.println(sb);
		}
		
		Sort selectionSort = new SelectionSort();
		ArrayList<Integer> result = selectionSort.doSort(array);
		

		System.out.println(result);
	}

}
