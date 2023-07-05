package Day2.B1874_스택수열;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class B1874_스택수열_Sol {
	public static void main(String[] args) {


		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int [] arr = new int [N];
		for(int i=0; i<N; i++) arr[i] = sc.nextInt();
		
		int idx = 1;
		Stack <Integer> stack = new Stack<>();
		StringBuilder builder = new StringBuilder();

		
		for(int i=0; i<N; i++) {
			int now = arr[i];
			
			if(stack.isEmpty() || now > stack.peek()) {
				for(int j = idx; j<=now; j++) {
					stack.push(idx);
					idx++;
					builder.append("+\n");
				}
				stack.pop();
				builder.append("-\n");
			}
			
			else if(now == stack.peek()) {
				stack.pop();
				builder.append("-\n");
			}
			
			else if(now < stack.peek()) {
				System.out.println("NO");
				return;
			}
			
		}
		
		System.out.println(builder.toString());
		

	}
}
