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
		
		System.out.print("배열의 크기 : ");
		
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
		
		System.out.print("검색할 값 : ");
		key = sc.nextInt();
		
		result = linearSearch(array, idx, key);
		
		if (result == -1)
			System.out.println("찾으시는 값이 없습니다.");
		else
			System.out.println(key + " 값은 " + result + "번째 리스트에 있습니다.");
	}

}
