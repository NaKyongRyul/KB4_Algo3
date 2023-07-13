package Day3.B2493_탑;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

class TowerInfo {
	int height;
	int index;
	TowerInfo(int height, int index) {
		this.height = height;
		this.index = index;
	}
}

public class B2493_탑_김현지 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());

		Stack <TowerInfo> stack = new Stack<>();
//		Stack <Integer> orderStack = new Stack<>();
		
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

		int [] answer = new int [N+1];
		int [] tower = new int [N];

		// 타워의 높이 배열에 추가
		for (int i=0; i<N; i++) {
			tower[i] = Integer.parseInt(tokenizer.nextToken());
		}

		// 방패 역할을 하는 타워의 높이와 순서 기억 (-> 방향)

		for (int j=0; j<N; j++) {
//			System.out.println("stack: " + stack.peek());
//			System.out.println("orderStack: " + orderStack);
			// 스택이 비어있지 않다면
			if (!stack.isEmpty()) {
				// 스택의 원소보다 현재 타워의 높이가 더 높다면
				if (stack.peek().height < tower[j]) {
					// 현재 타워보다 높이가 낮은 스택을 제거
					while (!stack.isEmpty() && (stack.peek().height < tower[j])) {
						stack.pop();
//						orderStack.pop();
					}
					// 현재 타워의 높이보다 낮은 스택들을 모두 제거시키면 
					// 현재 타워보다 높은 타워 존재한다면 정답에 추가
					// 현재 타워보다 높은 타워가 존재하지 않으면 초기화했던 0 유지 
					if (!stack.isEmpty()) {
						//answer[j] = orderStack.peek();
						answer[j] = stack.peek().index;
					}
//					stack.add(tower[j]);
//					orderStack.add(j+1);
					stack.add(new TowerInfo(tower[j], j+1));
				// 현재 타워의 높이보다 스택에 있는 타워의 높이가 높다면 레이저
				} else {
//					answer[j] = orderStack.peek();
					answer[j] = stack.peek().index;
//					stack.add.(tower[j]);
//					orderStack.add(j+1);
					stack.add(new TowerInfo(tower[j], j+1));

					
				}
			// 스택이 비어있다면 원소 추가
			} else {
//				stack.add(tower[j]);
//				orderStack.add(j+1);
				stack.add(new TowerInfo(tower[j], j+1));
			}
//			System.out.println(" stack: " + stack);
//			System.out.println(" orderStack: " + orderStack);

		}
		


		// 정답 출력
		for (int l=0; l<N; l++) {
			System.out.print(answer[l] + " ");
		}

	}

}
