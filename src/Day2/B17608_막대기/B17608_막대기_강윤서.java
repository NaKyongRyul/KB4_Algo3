package Day2.B17608_막대기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B17608_막대기_강윤서 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Integer> stack = new Stack<>();
		
		// 막대기 개수
		int n = Integer.parseInt(br.readLine());
		
		// 스택에 삽입
		for (int i=0; i<n; i++) {
			stack.push(Integer.parseInt(br.readLine()));
		}
		
		// 오른쪽에서 보았을 때 보이는 막대기 개수 계산
		int count = 0;
		int maxValue = stack.pop(); // 오른쪽에서 보았을 때 가려질 수도 있는 막대기 높이값
		// 높이값 비교
		while(!stack.isEmpty()) {
			int popValue = stack.pop();
			if (popValue>maxValue) { // 오른쪽에서 보았을 때 가려지지 않는 막대기라면
				count++;
			}
			if (popValue>maxValue) {
				maxValue = popValue;
			}
		}
		System.out.println(count+1);
	}
}
