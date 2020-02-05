package comp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import comp.VO.StudentVO;

public class compTest {

	public static void main(String[] args) {

		
		StudentVO[] array = {
				new StudentVO("�л�1", 170, 1.5),
				new StudentVO("�л�2", 180, 1.2)
		};
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("ã���÷��� Ű ���� �Է��ϼ��� : ");
		int height = -1;
		
		while ((height = sc.nextInt()) != -1) {
			StudentVO key = new StudentVO();
			key.setHeight(height);
			
			int result = Arrays.binarySearch(array, key, StudentVO.HEIGHT_ORDER);
			
			if (result < 0) {
				System.out.println("ã���ô� Ű�� ���� �л��� �����ϴ�.");
			} else {
				System.out.println(result + 1 + "��° �л� �Դϴ�.");
				System.out.println(array[result]);
			}
			
			System.out.println("ã���÷��� Ű ���� �Է��ϼ��� : ");
		} ;
		
		System.out.println("���α׷� ����");
	}
}
