package Day2.B1874_스택수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B1874_스택수열_박찬욱 { 

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine()); // 수열의 최대값이자, 수열의 길이
		int [] arr = new int [N]; // 원하는 수열을 놓기 위한 배열
		for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(bf.readLine()); // 원하는 수열
		
		
		int idx = 1; // push를 한 위치
		Stack <Integer> stack = new Stack<>(); // 스택
		StringBuilder builder = new StringBuilder(); // +-를 기록하기 위한 도구
		

		for(int i = 0; i < N; i++) {
			int now = arr[i]; // 원하는 수열의 순서에 맞게 필요한 숫자

			if(stack.isEmpty() || now > stack.peek()){ //스택이 비어있는 경우 & 필요한 숫자가 아닌 경우 -> now까지 push후, pop
				for(int j = idx; j <= now; j++) {
					stack.push(idx);
					idx++;
					builder.append("+\n");
				}
				stack.pop();
				builder.append("-\n");
			}

			else if(now == stack.peek()) { // 필요한 숫자인 경우 -> pop
				stack.pop();
				builder.append("-\n");
			}

			else if(now < stack.peek()) { // 필요한 숫자를 받을 수 없는 경우 -> Fail
				System.out.println("NO");
				return;
			}
		}
		System.out.println(builder.toString());
	}
}