package Day3.B2493_탑;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class B2493_탑_김현지 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());

		Stack <Integer> stack = new Stack<>();
		Stack <Integer> orderStack = new Stack<>();
		
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

		int [] answer = new int [N+1];
		int [] tower = new int [N];

		// 타워의 높이 배열에 추가
		for (int i=0; i<N; i++) {
			tower[i] = Integer.parseInt(tokenizer.nextToken());
		}

		// 방패 역할을 하는 타워의 높이와 순서 기억 (-> 방향)

		for (int j=0; j<N; j++) {
			// 스택이 비어있지 않다면
			if (!stack.isEmpty()) {
				if (stack.peek() < tower[j]) {
					while (!stack.isEmpty() && (stack.peek() < tower[j])) {
						stack.pop();
						orderStack.pop();			
					}
					stack.add(tower[j]);
					orderStack.add(j+1);
				} else {
					stack.add(tower[j]);
					orderStack.add(j+1);
					
				}
			// 스택이 비어있다면 원소 추가
			} else {
				stack.add(tower[j]);
				orderStack.add(j+1);
			}
			System.out.println(" stack: " + stack);
			System.out.println(" orderStack: " + orderStack);

		}
		
		// stack에서 원소를 꺼내면서 정답 배열 만들기 (<- 방향)
		for (int k=N-1; k>=0; k--) {
			System.out.println("answer stack: " + stack);
			System.out.println("answer: " + Arrays.toString(answer));
			if (!stack.isEmpty()) {
				answer[k+1] = orderStack.peek();
			} else if (stack.isEmpty()) {
				continue;
			}
			if (tower[k] >= stack.peek()) {
				stack.pop();
				orderStack.pop();
			} 
		}


		// 정답 출력
		for (int l=0; l<N; l++) {
			System.out.print(answer[l] + " ");
		}

	}

}
