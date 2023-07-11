package Day2.B1874_스택수열;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class B1874_스택수열_김현지 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
//		Queue <Integer> que = new ArrayDeque<>();
		Stack <Integer> stack = new Stack<>();
		Queue <String> queAnswer = new ArrayDeque<>();
		int [] inputNum = new int [N];
		
		
		for (int i=0; i<N; i++) {
			inputNum[i] = sc.nextInt();
		}
		
		boolean isAnswer = true;
		int increaseNum = 1;
		
		for(int i=0; i<N; i++) {
//			System.out.println("i:"+ inputNum[i]);
//			System.out.println("stack:"+ stack);
//			System.out.println("queAnswer:"+ queAnswer);
			if (stack.isEmpty()) {
				stack.add(increaseNum++);
				queAnswer.add("+");
			}
			if (stack.peek() <= inputNum[i]) {
				while (stack.peek() != inputNum[i]) {
					stack.add(increaseNum++);
					queAnswer.add("+");
				}
				stack.pop();
				queAnswer.add("-");
			} else {
				isAnswer = false;
				System.out.println("NO");
				return;
			}
		}
		if (isAnswer == true) {
			while (!queAnswer.isEmpty()) {
				System.out.println(queAnswer.poll());
			}
		
		

	}

}
}
