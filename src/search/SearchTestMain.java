package search;

import java.util.ArrayList;
import java.util.Scanner;

public class SearchTestMain {

	public static void main(String[] args) {

		int idx, key, result;

		System.out.print("�迭�� ũ�� : ");

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

		System.out.print("�˻��� �� : ");
		key = sc.nextInt();

		/**************** ���� �˻� ****************/
		/*
		Search linear = new LinearSearch();
		result = linear.doSearch(array, idx, key);				 
		*/
				
		/**************** ���� �˻� ****************/
		Search binary = new BinarySearch();			
		result = binary.doSearch(array, idx, key);

		if (result == -1)
			System.out.println("ã���ô� ���� �����ϴ�.");
		else
			System.out.println(key + " ���� " + result + "��° ����Ʈ�� �ֽ��ϴ�.");
	}

}
