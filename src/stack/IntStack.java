package stack;

import java.util.ArrayList;

public class IntStack <T> {
	private int ptr;
	private ArrayList<Integer> stack;

	public IntStack() {
		ptr = 0;
		try {
			stack = new ArrayList<Integer>();
		} catch (Exception e) {
			ptr = 0;
		}
	}
	
	public void push(int x) {		
		stack.add(x);
		ptr ++;
		
		System.out.println("Stack Push 완료");
	}
	
	public int pop()  {
		if (ptr <= 0) {
			System.out.println("꺼낼 Stack이 없습니다.");
			return -1;
		}
		
		return stack.remove(--ptr);
	}
	
	public void clear() {
		stack.clear();
		ptr = 0;
		System.out.println("Stack Clear 완료");
	}
	
	public int checkPtr() {
		return ptr;
	}
	
	public int peek() {
		return stack.get(ptr-1);
	}
	
	public int search(T x) {
		for (int i = 0; i < stack.size(); i++) {
			if (stack.get(i).equals(x)) {
				return i;
			}
		}
		return -1;
	}
	
}
