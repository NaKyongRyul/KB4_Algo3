package Day2.B1874_스택수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B1874_스택수열_길민지 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());

		int arr[] = new int[n];
		Stack<Integer> stack = new Stack<Integer>();
		StringBuilder builder = new StringBuilder();
		
		int idx = 1;
		
		for (int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}
		
		for (int i = 0; i<n; i++) {
			int now = arr[i];
			
			if (stack.isEmpty() || now > stack.peek()) {
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
				builder.setLength(0);
				builder.append("NO");
				break;
			}
		}
		System.out.println(builder.toString());
	}
}


