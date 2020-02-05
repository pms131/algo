package comp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import comp.VO.StudentVO;

public class compTest {

	public static void main(String[] args) {

		
		StudentVO[] array = {
				new StudentVO("학생1", 170, 1.5),
				new StudentVO("학생2", 180, 1.2)
		};
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("찾으시려는 키 값을 입력하세요 : ");
		int height = -1;
		
		while ((height = sc.nextInt()) != -1) {
			StudentVO key = new StudentVO();
			key.setHeight(height);
			
			int result = Arrays.binarySearch(array, key, StudentVO.HEIGHT_ORDER);
			
			if (result < 0) {
				System.out.println("찾으시는 키를 가진 학생이 없습니다.");
			} else {
				System.out.println(result + 1 + "번째 학생 입니다.");
				System.out.println(array[result]);
			}
			
			System.out.println("찾으시려는 키 값을 입력하세요 : ");
		} ;
		
		System.out.println("프로그램 종료");
	}
}
