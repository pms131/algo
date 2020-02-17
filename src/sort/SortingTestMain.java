package sort;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

public class SortingTestMain {

	public static void main(String[] args) {
		
		System.out.print("배열의 크기를 입력 하세요  : ");

		Scanner sc = new Scanner(System.in);
		
		try {
			int idx;
			
			idx = sc.nextInt();
			ArrayList<Integer> array = new ArrayList<>();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < idx; i++) {
				System.out.print( (i+1) + "번째 배열 값 : ");
				
				array.add(sc.nextInt());

				sb.append(array.get(i));

				if (i != idx - 1)
					sb.append(", ");
				else
					System.out.println(sb);
			}
			//Sort selectionSort = new SelectionSort();
			//Sort bubbleSort = new BubbleSort();
			Sort insertSort = new InsertSort();
			
			ArrayList<Integer> result = insertSort.doSort(array);
			
			System.out.println(result);
			
		} catch (Exception e) {
			Logger.getLogger(e.getMessage());
		} finally {
			sc.close();
		}
	}

}
