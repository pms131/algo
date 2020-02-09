package stack;

import java.util.Scanner;

public class StackTestMain {

	public static void main(String[] args) {
		
		IntStack<Integer> stack = new IntStack<>();
		Scanner sc = new Scanner(System.in);
		int key = 0;
		System.out.print("0 : 프로그램 종료, 1 : push, 2 : pop, 3: clear, "
							+ "4 : stackSize, 5 : peek, 6 : search : ");
		
		while ( (key = sc.nextInt() ) != 0) {
			switch (key) {
			case 0:
				break;
			case 1:
				System.out.print("push 할 값을 입력하세요 : ");
				int val = sc.nextInt();
				stack.push(val);
				break;
			case 2:
				int pop = stack.pop();
				if (pop != -1)
					System.out.println("pop값은 " + pop + " 입니다.");
				break;
			case 3:
				stack.clear();
				break; 
			case 4:
				int ptr = stack.checkPtr();
				System.out.println("현재 ptr의 위치는 " + ptr + " 입니다.");
				break;
			case 5:
				int peek = stack.peek();
				System.out.println("현재 peek 값은 : " + peek + " 입니다.");
				break;
			case 6:
				System.out.print("찾으실 값을 입력하세요 : ");
				int searchVal = sc.nextInt();
				int searchKey = stack.search(searchVal);
				
				if (searchKey == -1) 
					System.out.println("찾으시는 값이 없습니다.");
				else
					System.out.println(searchKey + " 번째 Stack에 " + searchVal + " 이 있습니다."); 
				break;
			default:
				break;
			}

			System.out.print("0 : 프로그램 종료, 1 : push, 2 : pop, 3: clear, "
					+ "4 : checkPtr, 5 : peek, 6 : search : ");
		};

		sc.close();
	}
}
