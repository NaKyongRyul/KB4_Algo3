package Day2;

import java.util.Stack;

public class StackTest {
	public static void main(String[] args) {
		
		Stack <Integer> stack = new Stack<>();
		
		System.out.println(stack);
		
		// push 메소드 -- O(1)
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println(stack);
		
		// add 메소드 -- O(1)
		stack.add(10);
		System.out.println(stack);
		
		// add(인덱스 , 값) -- O(N)
		stack.add(0,11);
		System.out.println(stack);
		
		// pop 메소드 = 삭제한값을 return -- O(1)
		int pop_value = stack.pop();
		System.out.println(stack);
		System.out.println("Pop : " + pop_value);
		
		// remove(인덱스) 메소드 -- O(N)
		stack.remove(2);
		System.out.println(stack);
		
		// peek 메소드 = 가장 위에 있는 값을 반환 = pop 했을때 삭제될값
		System.out.println(stack.peek());
		
		// isEmpty 메소드 = 스택이 비어있는지 확인
		System.out.println(stack.isEmpty());
		
		// clear 메소드 = 스택 초기화 (비어있는 상태)
		stack.clear();
		System.out.println(stack);
		System.out.println(stack.isEmpty());
		
	}

}
