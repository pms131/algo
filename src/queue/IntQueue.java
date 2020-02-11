package queue;

import java.util.ArrayList;
import java.util.logging.Logger;

public class IntQueue {

	private int maxSize;
	private final ArrayList<Integer> que;
	private int front;
	private int rear;
	
	public IntQueue(final int maxSize) throws Exception {
		this.maxSize = maxSize;
		front = rear = 0;
		que = new ArrayList<Integer>();
	}

	public boolean isEmpty() throws Exception {
		if (front == rear) {
			System.out.println("이 큐는 비어있습니다.");
			return true;
		}

		return false;
	}

	public boolean isFull() throws Exception {
		if (rear == maxSize)
			return true;

		return false;
	}

	public void enqueue (final int item) throws Exception {
		if (isFull()) {
			System.out.println("큐가 꽉 찼습니다. 큐 사이즈를 " + ++maxSize + "로 확장합니다.");
		}
		rear++;
		que.add(item);
	}

	public int dequeue() throws Exception {
		if (isEmpty()) 
			return -1;

		return que.get(--rear);
	}
	
	public int peek () throws Exception {
		if (isEmpty()) 
			return -1;

		return que.get(rear-1);
	}

	public void clear () throws Exception {
		System.out.println("이 큐를 clear 합니다.");

		front = rear = 0;

		que.clear();
	}
	
	public int search(final int key) throws Exception {
		for (int i = 0; i < que.size(); i++) {
			if (que.get(i).equals(key)) {
				return i;
			}
		}

		return -1;
	}

	//큐 안의 모든 데이터를 front -> rear 순으로 출력
	public void dump() throws Exception {
		int num = que.size();

		try {
			if (!isEmpty()) {
				for (int i=0; i<num; i++) {
					System.out.print(que.get((i+front) % maxSize) + " ");
				}
				System.out.println();
			}
		} catch (Exception e) {
			Logger.getLogger(e.getMessage());
		}
	}
}