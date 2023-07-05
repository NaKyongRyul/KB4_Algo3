package Day2.B1874_스택수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B1874_스택수열_전상희 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++)
			arr[i] = Integer.parseInt(bf.readLine());
		
		int idx = 1; // 어디까지 push했는지 기억할 인덱스
		Stack <Integer> stack = new Stack<>();
		StringBuilder builder = new StringBuilder(); // +, - 기억
		
		for(int i=0; i<N; i++) {
			int now = arr[i];
			if(stack.isEmpty() || now > stack.peek()) {
				for(int j=idx; j<=now; j++) {
					stack.push(idx);
					idx++;
					builder.append("+\n");// push, 정답 출력 양식을 고려해 줄바꿈 넣음 
				}
				stack.pop();
				builder.append("-\n");
			}
			else if(now == stack.peek()) {
				stack.pop();
				builder.append("-\n"); // pop
			}
			else if(now < stack.peek()) {
				System.out.println("NO");
				return; // 프로그램을 종료시킨다 , 안 넣으면 line 42가 찍힘
			}
		}
		
		System.out.println(builder.toString());
		
	}

}
