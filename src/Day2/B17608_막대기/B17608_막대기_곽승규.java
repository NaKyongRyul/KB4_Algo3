package Day2.B17608_막대기;

import java.util.Scanner;
import java.util.Stack;

public class B17608_막대기_곽승규 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < N; i++) {
			stack.push(sc.nextInt());
		}
		//System.out.println(stack);
		
		// 맨 뒤의 값 가지고 오기
		int rear = stack.peek();
		stack.pop(); // 맨 뒤 제거
		int count = 1; // 맨 뒤는 항상 보임
		
		
		while(!stack.isEmpty()) {
			int value = stack.pop();
			if (value > rear) {
				rear = value;
				count++;
			}
		}
		
		System.out.println(count);
	}		
}
