package stack;

import java.util.Scanner;

public class StackTestMain {

	public static void main(String[] args) {
		
		IntStack<Integer> stack = new IntStack<>();
		Scanner sc = new Scanner(System.in);
		int key = 0;
		System.out.print("0 : ���α׷� ����, 1 : push, 2 : pop, 3: clear, "
							+ "4 : stackSize, 5 : peek, 6 : search : ");
		
		while ( (key = sc.nextInt() ) != 0) {
			switch (key) {
			case 0:
				break;
			case 1:
				System.out.print("push �� ���� �Է��ϼ��� : ");
				int val = sc.nextInt();
				stack.push(val);
				break;
			case 2:
				int pop = stack.pop();
				if (pop != -1)
					System.out.println("pop���� " + pop + " �Դϴ�.");
				break;
			case 3:
				stack.clear();
				break;
			case 4:
				int ptr = stack.checkPtr();
				System.out.println("���� ptr�� ��ġ�� " + ptr + " �Դϴ�.");
				break;
			case 5:
				int peek = stack.peek();
				System.out.println("���� peek ���� : " + peek + " �Դϴ�.");
				break;
			case 6:
				System.out.print("ã���� ���� �Է��ϼ��� : ");
				int searchVal = sc.nextInt();
				int searchKey = stack.search(searchVal);
				
				if (searchKey == -1) 
					System.out.println("ã���ô� ���� �����ϴ�.");
				else
					System.out.println(searchKey + " ��° Stack�� " + searchVal + " �� �ֽ��ϴ�."); 
				break;
			default:
				break;
			}

			System.out.print("0 : ���α׷� ����, 1 : push, 2 : pop, 3: clear, "
					+ "4 : checkPtr, 5 : peek, 6 : search : ");
		};
	}
}
