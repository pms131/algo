package search;

import java.util.ArrayList;
import java.util.Scanner;

public class linear_search {
	
	private static int linearSearch(ArrayList<Integer> array, int idx, int key) {
		for(int i=0; i<idx; i++) {
			if (key == array.get(i))
				return i+1;
		}
		
		return -1;
	}

	public static void main(String[] args) {
		
		int idx, key, result;
		
		System.out.print("�迭�� ũ�� : ");
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		idx = sc.nextInt();
		
		ArrayList<Integer> array = new ArrayList<>();
		StringBuffer sb = new StringBuffer();
		
		for(int i=0; i<idx; i++) {
			array.add(sc.nextInt());
			
			sb.append(array.get(i));
			
			if (i != idx-1)
				sb.append(", ");
			else
				System.out.println(sb);
		}
		
		System.out.print("�˻��� �� : ");
		key = sc.nextInt();
		
		result = linearSearch(array, idx, key);
		
		if (result == -1)
			System.out.println("ã���ô� ���� �����ϴ�.");
		else
			System.out.println(key + " ���� " + result + "��° ����Ʈ�� �ֽ��ϴ�.");
	}

}
