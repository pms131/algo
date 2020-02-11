package queue;

import java.util.Scanner;
import java.util.logging.Logger;

public class QueueTestMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		try {	
			System.out.println("Queue의 Size를 입력하세요 : ");
			int size = sc.nextInt();
			IntQueue queue = new IntQueue(size);
	
			int key = 0;
			System.out.print("0 : 프로그램 종료, 1 : enqueue, 2 : dequeue, 3: clear, "
								+ "4 : dump, 5 : peek, 6 : search : ");
			
			while ( (key = sc.nextInt() ) != 0) {
				switch (key) {
				case 0:
					break;
				case 1:
					System.out.print("enqueue 할 값을 입력하세요 : ");
					int val = sc.nextInt();
					queue.enqueue(val);
					break;
				case 2:
					int dequeue = queue.dequeue();
					if (dequeue != -1)
						System.out.println("dequeue값은 " + dequeue + " 입니다.");
					break;
				case 3:
					queue.clear();
					break; 
				case 4:
					System.out.println("dump를 시작합니다..");
					queue.dump();
					break;
				case 5:
					int peek = queue.peek();
					System.out.println("현재 peek 값은 : " + peek + " 입니다.");
					break;
				case 6:
					System.out.print("찾으실 값을 입력하세요 : ");
					int searchVal = sc.nextInt();
					int searchKey = queue.search(searchVal) + 1;
					
					if (searchKey == -1) 
						System.out.println("찾으시는 값이 없습니다.");
					else
						System.out.println(searchKey + " 번째 queue에 " + searchVal + " 이 있습니다."); 
					break;
				default:
					break;
				}
	
				System.out.print("0 : 프로그램 종료, 1 : enqueue, 2 : dequeue, 3: clear, "
				+ "4 : dump, 5 : peek, 6 : search : ");
			};
		} catch (Exception error) {
			Logger.getLogger(error.getMessage());
		} finally {
			sc.close();
		}

	}
}
