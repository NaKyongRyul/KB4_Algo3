package Day2.B1874_스택수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B1874_스택수열_김태선 {

	public static void main(String[] args) throws Exception, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		Stack <Integer> stack = new Stack <> ();
		
		int start = 1;
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num >= start) {
				for(int j = start; j <= num; j++) {
					stack.push(j);
					sb.append("+ \n");	
				}
				start = num + 1;		
			}
			else if(num != stack.peek()) {
				System.out.println("NO");
				System.exit(0);
			}
			while(!stack.empty()) {
				sb.append("- \n");
				if(stack.pop() == num) break;
			}
			
		}
	
		System.out.println(sb.toString());

	}
}