package Day2.B17608_막대기;

import java.util.Scanner;
import java.util.Stack;

public class B17608_막대기_김현지 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		Stack <Integer> stack = new Stack<>();
		// 첫 번째 원소 스택에 추가
		stack.push(sc.nextInt());
		
		for (int i=1; i<N; i++) {
			stack.push(sc.nextInt());
			}
		
		int cnt = 1;
		int stick = stack.peek();
		for (int j=0; j<N; j++) {
			int newStick = stack.pop();
			if (stick < newStick) {
				cnt += 1;
				stick = newStick;
			}
		
		}
		System.out.println(cnt);

	}

}
