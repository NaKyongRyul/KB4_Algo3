package Day3.B2493_탑;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B2493_탑_강윤서 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 탑 개수
		
		// 탑 높이
		StringTokenizer st = new StringTokenizer(br.readLine());
		int [] height = new int[n]; // 탑 높이
		for (int i=0; i<n; i++) {
			height[i] = Integer.parseInt(st.nextToken());
		}
		
		// 스택에 탑 위치 삽입할 때. 중간 탑 제거하며, 수신한 탑 위치 확인
		Stack <Integer> stack = new Stack<>(); // 탑 위치를 저장하는 스택
		int [] result = new int[n]; // 결과
		
		for(int i=0; i<n; i++) {
			int now = height[i]; // 삽입할 탑 높이
			// 삽입할 탑, 수신할 탑 사이의 작은 높이 탑(중간 탑) 제거
			while (!stack.isEmpty() && height[stack.peek()] < now) { // 삽입할 탑 높이보다 작은 높이 탑(중간 탑)
				stack.pop(); // 스택에서 탑 위치 제거
			}
			
			// 수신한 탑 위치 확인
			if(!stack.isEmpty()) {
				result[i] = stack.peek()+1;
			}
			
			// 스택에 탑 위치 삽입
			stack.push(i);
		}
		// 결과 출력
		for (int i=0; i<n; i++) {
			System.out.print(result[i] + " ");
		}
	}
}
