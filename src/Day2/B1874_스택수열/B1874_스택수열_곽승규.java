package Day2.B1874_스택수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B1874_스택수열_곽승규 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder answer = new StringBuilder();
		
		int start = 0;
		
		Stack <Integer> stack = new Stack<>();
		
		for (int i = 0; i < N; i++) {
			
			//원하는 값
			int num = Integer.parseInt(br.readLine());
			
			if (num > start) {
					
				//value까지 push
				for (int j = start + 1; j <= num; j++) {
					stack.push(j);
					answer.append("+\n");
				}
				start = num;
			}
			
			else if (stack.peek() != num) {
				System.out.println("NO");
				return;
			}
		
			//value까지 push했으니 pop()함.
			stack.pop();
			answer.append("-\n");
			
		}
		
		System.out.println(answer);
		

	}

}
