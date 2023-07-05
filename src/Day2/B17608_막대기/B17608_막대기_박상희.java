package Day2.B17608_막대기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B17608_막대기_박상희 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());

		Stack<Integer> stack = new Stack<>();
		for (int n = 0; n < N; n++) {
			stack.push(Integer.parseInt(bf.readLine()));
		}
		
		int answer = 0;
		int maxNum = 0;
		while (!stack.isEmpty()) {
			int currentNum = stack.pop();
			
			if (currentNum > maxNum) {
				answer++;
			}
			
			maxNum = Math.max(maxNum, currentNum);
		}
		
		System.out.println(answer);
	}
}
