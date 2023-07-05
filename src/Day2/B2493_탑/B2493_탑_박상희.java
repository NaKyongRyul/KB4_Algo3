package Day2.B2493_탑;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B2493_탑_박상희 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine()); // 탑의 수
		
		StringTokenizer token = new StringTokenizer(bf.readLine(), " ");
		
		int height[] = new int[N]; // 탑의 높이
		for (int n = 0; n < N; n++) {
			height[n] = Integer.parseInt(token.nextToken());
		}
		
		Stack<int[]> stack = new Stack<>();
		for (int i = 0; i < N; i++) { // 탑의 수만큼 반복
			while (!stack.isEmpty()) { // 스택에 값이 있을 때
				if (height[i] > stack.peek()[1]) { // 현재 탑의 높이가 더 높을 경우
					stack.pop();
				}
				else { // 현재 탑의 높이가 더 낮을 경우
					System.out.print(stack.peek()[0] + " ");
					break;
				}
			}
			
			if (stack.isEmpty()) { // 스택에 값이 없을 때
				System.out.print("0 ");
			}
			
			stack.push(new int[] {i + 1, height[i]}); // {탑 순서, 탑 높이}
		}
	}
}
