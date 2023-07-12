package Day2.B1874_스택수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class B1874_스택수열_강윤서 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine()); // 수열 숫자 개수
		
		// 수열
		int [] numList = new int[n];
		for (int i=0; i<n; i++) {
			numList[i] = Integer.parseInt(br.readLine());
		}
		
		// 수열을 만들기 위해 필요한 연산 과정
		Stack <Integer> stack = new Stack<>(); // pop하면서 수열 만드는 스택
		Queue <Character> result = new ArrayDeque<>(); // push, pop 연산 결과
		
		int pushNum = 1; // push 할 값
		int valid = 1; // 수열 유효하게 만들 수 있는지 확인
		
		for (int i=0; i<n; i++) { // 수열에서 모든 값 하나씩 확인
			if (numList[i]>=pushNum) { // 수열 만들 값이 현재 stack에서 아직 push되지 않았으면-필요한만큼 push 후 pop
				for (int j=pushNum; j<numList[i]+1; j++) { // push
					stack.push(j);
					pushNum++;
					result.offer('+');
				}
				
				stack.pop(); // pop
				result.offer('-');
			} else if(numList[i]==stack.peek()) { // 수열 만들 값이 현재 stack에서 pop할 값과 같으면-해당 값 pop
				 stack.pop(); // pop
				 result.offer('-');
			} else { // pop할 값이 
				valid = 0;
				break;
			}
		}
		// 결과 출력
		if (valid==0) {
			System.out.println("NO");
		} else {
			while(!result.isEmpty()) {
				System.out.println(result.poll());
			}
		}
	}
}
